-- --------- user --------- --
CREATE TABLE "user" (
    id bigint NOT NULL,
    username character varying(64),
    password character varying(256),
    "firstName" character varying(64),
    "lastName" character varying(64)
);

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE user_id_seq OWNED BY "user".id;

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);

ALTER TABLE ONLY "user" ADD CONSTRAINT user_name UNIQUE (username);

ALTER TABLE ONLY "user" ADD CONSTRAINT user_pkey PRIMARY KEY (id);

CREATE INDEX user_username_idx ON "user" USING btree (username);
-- --------- /user --------- --

-- --------- group --------- --
CREATE TABLE "group" (
    id bigint NOT NULL,
    "userId" bigint NOT NULL,
    "groupName" character varying(64),
    "groupDesc" character varying(256)
);

CREATE SEQUENCE group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE group_id_seq OWNED BY "group".id;

ALTER TABLE ONLY "group" ALTER COLUMN id SET DEFAULT nextval('group_id_seq'::regclass);

ALTER TABLE ONLY "group" ADD CONSTRAINT group_pkey PRIMARY KEY (id);
-- --------- /group --------- --

-- --------- contact --------- --
CREATE TABLE "contact" (
    id bigint NOT NULL,
    "groupId" bigint NOT NULL,
    "contactName" character varying(128),
    "firstName" character varying(64),
    "lastName" character varying(64),
    "phoneNO" character varying(64),
    "officePhone" character varying(64),
    "familyPhone" character varying(64),
    "contactAdd" character varying(256)
);

CREATE SEQUENCE contact_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE contact_id_seq OWNED BY "contact".id;

ALTER TABLE ONLY "contact" ALTER COLUMN id SET DEFAULT nextval('contact_id_seq'::regclass);

ALTER TABLE ONLY "contact" ADD CONSTRAINT contact_pkey PRIMARY KEY (id);
-- --------- /contact --------- --