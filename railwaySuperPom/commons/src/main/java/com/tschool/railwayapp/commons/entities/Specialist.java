package com.tschool.railwayapp.commons.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Specialist extends SuperUser implements Serializable {}
