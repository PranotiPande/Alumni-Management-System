package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Event;

public interface IEventDao extends JpaRepository<Event, Integer>{

}
