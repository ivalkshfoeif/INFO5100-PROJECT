# INFO5100-PROJECT

This is an implementation for famous Object-Oriented Design question "Design a parking lot"


## Installation

The project is based on Maven and Java 11 or higher version

You can find the jar file here : https://drive.google.com/file/d/1mB37edebWXx0UzOqc4pRd1ox-onALsbN/view?usp=sharing

Or import the code to Intellj and run Main.java

<img width="1874" alt="Screen Shot 2022-12-13 at 5 49 30 AM" src="https://user-images.githubusercontent.com/61750044/207345589-e8a18265-5608-4aab-ab2d-da472f23ded4.png">

## Highlights

- User-friendly UI and promotion
- Sqlite integration and Database Mapper implementation with SQL query
- File structure convention
- Name convention
- S.L.I.O.D Principle
- Object-Oriented Design Pattern


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
| start_timestamp | STRING |
| end_timestamp   | STRING |
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
