package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value ="SELECT mode, COUNT(*) \n" +
            " FROM appointments \n" +
            " GROUP BY mode ;" ,nativeQuery = true)
    public List<String[]>cantidadModalidadesCitas();

    @Query(value = "SELECT \n" +
            "    r.tipo_rol AS tipo_rol,\n" +
            "    p.full_name AS nombre_personal,\n" +
            "    c.full_name AS nombre_paciente\n" +
            "FROM \n" +
            "    users c\n" +
            "JOIN \n" +
            "    appointments ap ON c.id_user = ap.id_cliente\n" +
            "JOIN \n" +
            "    users p ON ap.id_personal = p.id_user\n" +
            "JOIN\n" +
            "    users bp ON bp.full_name = p.full_name\n" +
            "JOIN \n" +
            "    rol r ON r.id_rol = p.id_rol\n" +
            "WHERE \n" +
            "    (\n" +
            "        r.tipo_rol = 'ENFERMERO'\n" +
            "        OR\n" +
            "        r.tipo_rol = 'DOCTOR'\n" +
            "    )\n" +
            "AND \n" +
            "    p.full_name LIKE :personal", nativeQuery = true)
    public List<String[]> listarPacientesPorPersonal(@Param("personal") String personal);

    @Query(value = "SELECT c.full_name\n" +
            " FROM appointments ap\n" +
            " JOIN users c ON ap.id_cliente = c.id_user\n" +
            " WHERE TO_CHAR(ap.date, 'DD-MM-YYYY') LIKE :fecha", nativeQuery = true)
    public List<String[]> listarPacientesPorFecha(@Param("fecha") String fecha);

    @Query(value = "SELECT u.dni, u.full_name, count(*) as q " +
                   "FROM users u " +
                   "INNER JOIN appointments ap ON u.id_user = ap.id_cliente " +
                   "WHERE u.id_rol = 1 AND (TO_CHAR(ap.date, 'DD-MM-YYYY') BETWEEN :date1 AND :date2) " +
                   "GROUP BY u.dni, u.full_name", nativeQuery = true)
    public List<String[]> cantidadCitasPeriodo(@Param("date1") String date1, @Param("date2") String date2);


}
