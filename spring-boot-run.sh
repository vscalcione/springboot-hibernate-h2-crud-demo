#!/bin/bash

mvn clean install -U -DSkipTests=true
mvn spring-boot:run