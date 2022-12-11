# INFO5100-PROJECT

## Installation



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
