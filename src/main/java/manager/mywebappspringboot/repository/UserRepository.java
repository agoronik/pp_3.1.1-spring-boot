package manager.mywebappspringboot.repository;

import manager.mywebappspringboot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
