INSERT INTO users (id, user_name, role) VALUES ('0df29411-adef-4dca-9297-2d83c5c73321', 'admin', 'admin-role');
INSERT INTO users (id, user_name, role) VALUES ('d6425a6a-5914-475d-a217-b51487a26a20', 'manager', 'manage-role');
INSERT INTO users (id, user_name, role) VALUES ('b4e4ab1f-29d5-4397-b793-5fcb6343eca2', 'simple-user', 'simple-user-role');

INSERT INTO posts (title, user_id, status) VALUES ('admin-post-1', '0df29411-adef-4dca-9297-2d83c5c73321', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('admin-post-2', '0df29411-adef-4dca-9297-2d83c5c73321', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('admin-post-3', '0df29411-adef-4dca-9297-2d83c5c73321', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('admin-post-4', '0df29411-adef-4dca-9297-2d83c5c73321', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('admin-post-5', '0df29411-adef-4dca-9297-2d83c5c73321', 'published');

INSERT INTO posts (title, user_id, status) VALUES ('manager-post-1', 'd6425a6a-5914-475d-a217-b51487a26a20', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('manager-post-2', 'd6425a6a-5914-475d-a217-b51487a26a20', 'published');
INSERT INTO posts (title, user_id, status) VALUES ('manager-post-3', 'd6425a6a-5914-475d-a217-b51487a26a20', 'published');