create table categories
(
    id    bigserial primary key,
    title varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
insert into categories (title)
values ('Food');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
insert into products (title, price, category_id)
values ('Bread', 25, 1),
       ('Milk', 80, 1),
       ('Cheese', 450, 1),
       ('Cheese1', 450, 1),
       ('Cheese2', 450, 1),
       ('Cheese3', 450, 1),
       ('Cheese4', 450, 1),
       ('Cheese5', 450, 1),
       ('Cheese6', 450, 1),
       ('Cheese7', 450, 1),
       ('Cheese8', 450, 1),
       ('Cheese9', 450, 1),
       ('Cheese10', 450, 1),
       ('Cheese11', 450, 1),
       ('Cheese12', 450, 1),
       ('Cheese13', 450, 1),
       ('Cheese14', 450, 1),
       ('Cheese15', 450, 1),
       ('Cheese16', 450, 1),
       ('Cheese17', 450, 1),
       ('Cheese18', 450, 1);

create table users
(
    id         bigserial primary key,
    first_name varchar(80) not null,
    last_name  varchar(80) not null,
    username   varchar(30) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

create table commentaries
(
    id          bigserial primary key,
    content     varchar(255),
    user_id     bigint references users (id),
    product_id  bigint references products (id),
    created_at  timestamp default current_timestamp
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, first_name, last_name, password, email)
values ('user', 'Bob', 'Johnson', '$2a$12$90tN4/VUgeZlgDt7grx48OAH9GM8VkBlcSTrKtC.nVYvmu22Zt.l.', 'user@gmail.com'), -- user/user
       ('admin', 'John', 'Johnson', '$2a$12$Lyiu7NVkcCPZ8bhuPNwtdubWz4nkuR75UG1sz2pqE44LCS9O2fY1u', 'admin@gmail.com'); -- admin/admin

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table orders
(
    id         bigserial primary key,
    user_id    bigint references users (id),
    address    varchar(255),
    phone      varchar(255),
    price      integer,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    order_id          bigint references orders (id),
    product_id        bigint references products (id),
    quantity          integer,
    price_per_product integer,
    price             integer,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into orders (user_id, address, phone, price)
values (1, '1111', '1111', 100);

insert into order_items (order_id, product_id, quantity, price_per_product, price)
values (1, 1, 4, 25, 100);

insert into commentaries (content, user_id, product_id)
values ('Good!', 1, 1);
