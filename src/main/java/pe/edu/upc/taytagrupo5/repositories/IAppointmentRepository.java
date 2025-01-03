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
            "    p.id_user =:personal", nativeQuery = true)
    public List<String[]> listarPacientesPorPersonal(@Param("personal") Integer personal);

    @Query(value = "SELECT c.full_name\n" +
            " FROM appointments ap\n" +
            " JOIN users c ON ap.id_cliente = c.id_user\n" +
            " WHERE TO_CHAR(ap.date, 'DD-MM-YYYY') LIKE :fecha", nativeQuery = true)
    public List<String[]> listarPacientesPorFecha(@Param("fecha") String fecha);

    @Query(value = " SELECT u.dni, u.full_name, COUNT(*) AS q \n" +
            " FROM users u \n" +
            " INNER JOIN appointments ap ON u.id_user = ap.id_cliente \n" +
            " INNER JOIN rol r ON u.id_rol = r.id_rol \n" +
            " WHERE r.tipo_rol = 'CLIENTE' \n" +
            " AND (TO_CHAR(ap.date, 'YYYY-MM-DD') BETWEEN :date1 AND :date2) \n" +
            " GROUP BY u.dni, u.full_name ", nativeQuery = true)
    public List<String[]> cantidadCitasPeriodo(@Param("date1") String date1, @Param("date2") String date2);

}
