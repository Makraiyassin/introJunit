package be.digitalcity.tu.pluralSightCourses.PS_Security.module4;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
