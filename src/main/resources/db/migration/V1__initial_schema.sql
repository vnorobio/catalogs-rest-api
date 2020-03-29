CREATE TABLE "zone"
(
    id serial NOT NULL,
    description character varying(255) NOT NULL,
    CONSTRAINT zone_pkey PRIMARY KEY (id),
    CONSTRAINT zone_description_key UNIQUE (description)
);

ALTER TABLE "zone" OWNER to postgres;

CREATE TABLE "city"
(
    id serial NOT NULL,
    description character varying(255),
    zone integer NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id),
    CONSTRAINT city_description_key UNIQUE (description),
    CONSTRAINT fkcity546664 FOREIGN KEY (zone)
        REFERENCES "zone" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "city" OWNER to postgres;

CREATE TABLE "clinic_type"
(
    id serial NOT NULL,
    description character varying(255),
    CONSTRAINT clinic_type_pkey PRIMARY KEY (id),
    CONSTRAINT clinic_type_description_key UNIQUE (description)
);

ALTER TABLE "clinic_type" OWNER to postgres;

CREATE TABLE "clinic"
(
    id serial NOT NULL,
    name character varying(255),
    administator character varying(255),
    email character varying(255),
    director character varying(255),
    city integer NOT NULL,
    capacity integer NOT NULL,
    clinic_type integer NOT NULL,
    CONSTRAINT clinic_pkey PRIMARY KEY (id),
    CONSTRAINT fkclinic594094 FOREIGN KEY (city)
        REFERENCES public.city (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkclinic723924 FOREIGN KEY (clinic_type)
        REFERENCES "clinic_type" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "clinic" OWNER to postgres;

CREATE TABLE "nephrologist_type"
(
    id serial NOT NULL,
    description character varying(255),
    CONSTRAINT nephrologist_type_pkey PRIMARY KEY (id),
    CONSTRAINT nephrologist_type_description_key UNIQUE (description)
);

ALTER TABLE "nephrologist_type" OWNER to postgres;

CREATE TABLE "nephrologist"
(
    id serial NOT NULL,
    name character varying(255),
    email character varying(255),
    active smallint NOT NULL,
    nephrologist_type integer NOT NULL,
    CONSTRAINT nephrologist_pkey PRIMARY KEY (id),
    CONSTRAINT fknephrologi581505 FOREIGN KEY (nephrologist_type)
        REFERENCES "nephrologist_type" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "nephrologist" OWNER to postgres;

CREATE TABLE "nephrologist_base_clinic"
(
    id serial NOT NULL,
    nephrologist integer NOT NULL,
    clinic integer NOT NULL,
    salary numeric(26,6) NOT NULL DEFAULT 0,
    didication_hours numeric(19,6) NOT NULL,
    CONSTRAINT nephrologist_base_clinic_pkey PRIMARY KEY (id),
    CONSTRAINT fknephrologi167763 FOREIGN KEY (nephrologist)
        REFERENCES "nephrologist" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknephrologi374569 FOREIGN KEY (clinic)
        REFERENCES "clinic" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE "nephrologist_base_clinic" OWNER to postgres;
