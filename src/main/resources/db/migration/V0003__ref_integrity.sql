CREATE TABLE IF NOT EXISTS pets
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    nickname VARCHAR(32) NOT NULL,
    CONSTRAINT pets_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS dogs
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    breed VARCHAR(32) NOT NULL,
    CONSTRAINT dogs_pkey PRIMARY KEY (id),
    CONSTRAINT dogs_id_fkey FOREIGN KEY (id) REFERENCES pets (id)
);