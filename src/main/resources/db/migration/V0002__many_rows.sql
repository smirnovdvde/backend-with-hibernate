CREATE TABLE IF NOT EXISTS many_rows
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    name VARCHAR(32) NOT NULL,
    CONSTRAINT manyrows_pkey PRIMARY KEY (id)
);