
DROP TABLE IF EXISTS info CASCADE;
create table info(
  id serial PRIMARY KEY,
  name text NOT NULL,
  age text,
  address text
);

INSERT INTO info(name,age,address) VALUES('平野',31,'横浜市'),('森',33,'つくば市');

SELECT id,name,age,address FROM info WHERE id = 2;
