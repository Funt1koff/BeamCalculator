create sequence load_seq start with 1 increment by 50;

CREATE TABLE load (
            coordinate double_precision(53),
            value double_precision(53),
            id bigint not null, primary key (id)
);