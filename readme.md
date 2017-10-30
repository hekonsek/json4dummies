# json4dummies

[![Version](https://img.shields.io/badge/json4dummies-0.0-blue.svg)](https://github.com/hekonsek/json4dummies/releases)

**json4dummies** is an opinionated wrapper around [Jackson](https://github.com/FasterXML/jackson) relying on static per-JVM
configuration.

## Usage

### Converting objects to JSON 

    Person person = ...;
    String json = Json.toJson(person);
    byte[] jsonBytes = Json.toJsonBytes(person);

### Reading JSON

    String json = ...;
    Person person = Json.fromJson(json, Person);
    Map<String, Object> personMap = Json.fromJson(json);
    
The same from an array of bytes:
    
    byte[] json = ...;
    Person person = Json.fromJson(json, Person);
    Map<String, Object> personMap = Json.fromJson(json);