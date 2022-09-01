package com.codestates.coffee.repository;

import com.codestates.coffee.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    // TODO 예제 코드에 나와있는 쿼리 메서드를 정의해보세요.
}
