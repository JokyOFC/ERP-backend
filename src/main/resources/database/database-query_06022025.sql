CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS type_person (
	id serial CONSTRAINT pk_id_person PRIMARY KEY NOT NULL,
	description varchar(30) UNIQUE NOT NULL,
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS persons (
	id serial CONSTRAINT pk_id_persons PRIMARY KEY NOT NULL,
	name varchar(255) NOT NULL,
	corporate_name varchar(255) NOT NULL,
	social_name varchar(255),
	ie_rg int NOT NULL,
	cpf_cnpj varchar(14) NOT NULL,
	email varchar(255) NOT NULL,
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS type_person_persons (
	id serial CONSTRAINT pk_type_person_persons PRIMARY KEY NOT NULL,
	type_person_id integer NOT NULL,
	person_id integer NOT NULL,
	FOREIGN KEY (type_person_id) REFERENCES type_person (id),
	FOREIGN KEY (person_id) REFERENCES persons (id),
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  	updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

ALTER TABLE persons ADD creation_date date NOT NULL;

CREATE TRIGGER set_timestamp_relational_person
BEFORE UPDATE ON type_person_persons
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER set_timestamp_type_person
BEFORE UPDATE ON type_person
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER set_timestamp_persons
BEFORE UPDATE ON persons
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();