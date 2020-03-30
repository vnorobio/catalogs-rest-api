CREATE TABLE "zone"
(
    zone_id serial NOT NULL,
    description character varying(255) NOT NULL,
    CONSTRAINT zone_pkey PRIMARY KEY (zone_id),
    CONSTRAINT zone_description_key UNIQUE (description)
);

ALTER TABLE "zone" OWNER to postgres;

CREATE TABLE "city"
(
    city_id serial NOT NULL,
    description character varying(255),
    zone integer NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (city_id),
    CONSTRAINT city_description_key UNIQUE (description),
    CONSTRAINT fkcity546664 FOREIGN KEY (zone)
        REFERENCES "zone" (zone_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "city" OWNER to postgres;

CREATE TABLE "clinic_type"
(
    clinic_type_id serial NOT NULL,
    description character varying(255),
    CONSTRAINT clinic_type_pkey PRIMARY KEY (clinic_type_id),
    CONSTRAINT clinic_type_description_key UNIQUE (description)
);

ALTER TABLE "clinic_type" OWNER to postgres;

CREATE TABLE "clinic"
(
    clinic_id serial NOT NULL,
    name character varying(255),
    administrator character varying(255),
    email character varying(255),
    director character varying(255),
    city integer NOT NULL,
    capacity integer NOT NULL,
    clinic_type integer NOT NULL,
    CONSTRAINT clinic_pkey PRIMARY KEY (clinic_id),
    CONSTRAINT fkclinic594094 FOREIGN KEY (city)
        REFERENCES "city" (city_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkclinic723924 FOREIGN KEY (clinic_type)
        REFERENCES "clinic_type" (clinic_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "clinic" OWNER to postgres;

CREATE TABLE "nephrologist_type"
(
    nephrologist_type_id serial NOT NULL,
    description character varying(255),
    CONSTRAINT nephrologist_type_pkey PRIMARY KEY (nephrologist_type_id),
    CONSTRAINT nephrologist_type_description_key UNIQUE (description)
);

ALTER TABLE "nephrologist_type" OWNER to postgres;

CREATE TABLE "nephrologist"
(
    nephrologist_id serial NOT NULL,
    name character varying(255),
    email character varying(255),
    active smallint NOT NULL,
    nephrologist_type integer NOT NULL,
    CONSTRAINT nephrologist_pkey PRIMARY KEY (nephrologist_id),
    CONSTRAINT fknephrologi581505 FOREIGN KEY (nephrologist_type)
        REFERENCES "nephrologist_type" (nephrologist_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "nephrologist" OWNER to postgres;

CREATE TABLE "nephrologist_base_clinic"
(
    base_clinic_id serial NOT NULL,
    nephrologist integer NOT NULL,
    clinic integer NOT NULL,
    salary numeric(26,6) NOT NULL DEFAULT 0,
    dedication_hours numeric(19,6) NOT NULL,
    CONSTRAINT nephrologist_base_clinic_pkey PRIMARY KEY (base_clinic_id),
    CONSTRAINT fknephrologi167763 FOREIGN KEY (nephrologist)
        REFERENCES "nephrologist" (nephrologist_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknephrologi374569 FOREIGN KEY (clinic)
        REFERENCES "clinic" (clinic_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "nephrologist_base_clinic" OWNER to postgres;
