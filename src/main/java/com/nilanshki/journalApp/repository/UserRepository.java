package com.nilanshki.journalApp.repository;

import com.nilanshki.journalApp.entity.JournalEntry;
import com.nilanshki.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
    User deleteByUserName(String userName);
}
