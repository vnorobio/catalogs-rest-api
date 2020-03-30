CREATE TABLE "user"
(
    user_id serial NOT NULL,
    login character varying(255)NOT NULL,
    password character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (user_id),
    CONSTRAINT user_email_key UNIQUE (email),
    CONSTRAINT user_login_key UNIQUE (login)
);

ALTER TABLE "user" OWNER to postgres;