# INFO5100-PROJECT

This is an implementation for Object-Oriented Design question "Design a parking lot"


## Installation

The project is based on Maven and Java 11 or higher version

You can find the jar file here : https://drive.google.com/file/d/1mB37edebWXx0UzOqc4pRd1ox-onALsbN/view?usp=sharing

Or import the code to Intellj and run Main.java


## Database 

```xml
    <dependency>
      <groupId>org.xerial</groupId>
      <artifactId>sqlite-jdbc</artifactId>
      <version>3.40.0.0</version>
    </dependency>
```

### Database Scheme

Records

| Name            | Type      |
|-----------------|-----------|
| record_id       | STRING    |
| plate_number    | STRING    |
| start_timestamp | TIMESTAMP |
| end_timestamp   | TIMESTAMP |
| record_status   | STRING    |
| spot_id         | STRING    |
| vehicle_type    | STRING    |
| amount          | DOUBLE    |

Spots

| Name          | Type      |
|---------------|-----------|
| spot_id       | STRING    |
| spot_type     | STRING    |
| spot_status   | STRING    |
