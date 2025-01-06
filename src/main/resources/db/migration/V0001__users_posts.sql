CREATE TABLE IF NOT EXISTS users
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    user_name VARCHAR(256) NOT NULL,
    role VARCHAR(256) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS posts
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    title VARCHAR(1024) NOT NULL,
    body TEXT,
    user_id UUID NOT NULL,
    status VARCHAR(16) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    CONSTRAINT posts_pkey PRIMARY KEY (id),
    CONSTRAINT posts_userid_fkey FOREIGN KEY (user_id) REFERENCES users (id)
);
