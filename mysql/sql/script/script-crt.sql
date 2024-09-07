/*crt-type*/
create table type (
    type_id int not null auto_increment,
    type_code varchar(32) unique,
    type_name_en varchar(32),
    type_name_ja varchar(32),
    constraint type_pk primary key (type_id)
);
/*crt-move*/
create table move_cat (
    move_cat_id int not null auto_increment,
    move_cat_code varchar(32) unique,
    move_cat_name_en varchar(32),
    move_cat_name_ja varchar(32),
    constraint move_cat_pk primary key (move_cat_id)
);

create table move_eff (
    move_eff_id int not null auto_increment,
    move_eff_code varchar(32) unique,
    move_eff_desc_en varchar(1000),
    move_eff_desc_ja varchar(1000),
    constraint move_eff_pk primary key (move_eff_id)
);

create table move_trgt (
    move_trgt_id int not null auto_increment,
    move_trgt_code varchar(32) unique,
    move_trgt_name_en varchar(32),
    move_trgt_name_ja varchar(32),
    constraint move_eff_pk primary key (move_trgt_id)
);

create table move_mthd (
    move_mthd_id int not null auto_increment,
    move_mthd_code varchar(32) unique,
    move_mthd_name_en varchar(32),
    move_mthd_name_ja varchar(32),
    constraint move_mthd_pk primary key (move_mthd_id)
);

create table move (
    move_id int not null auto_increment,
    move_code varchar(32) unique,
    move_name_en varchar(32),
    move_name_ja varchar(32),
    move_pp int,
    move_bp int,
    move_ac int,
    move_prio int,
    move_is_bright bool,
    move_is_king bool,
    move_is_contact bool,
    type_id int,
    move_cat_id int,
    move_trgt_id int,
    constraint move_pk primary key (move_id),
    constraint move_fk_type foreign key (type_id) 
        references type(type_id) on delete cascade,
    constraint move_fk_move_cat foreign key (move_cat_id) 
        references move_cat(move_cat_id) on delete cascade,
    constraint move_fk_move_trgt foreign key (move_trgt_id) 
        references move_trgt(move_trgt_id) on delete cascade
);

create table move_cause_eff (
    move_id int not null,
    move_eff_id int not null,
    rate int,
    constraint move_cause_eff_pk primary key (move_id, move_eff_id),
    constraint move_cause_eff_fk_move foreign key (move_id) 
        references move(move_id) on delete cascade,
    constraint move_cause_eff_fk_move_eff foreign key (move_eff_id) 
        references move_eff(move_eff_id) on delete cascade
);

create table move_considered_mthd (
    move_id int not null,
    move_mthd_id int not null,
    constraint move_considered_mthd_pk primary key (move_id, move_mthd_id),
    constraint move_considered_mthd_fk_move foreign key (move_id) 
        references move(move_id) on delete cascade,
    constraint move_considered_mthd_fk_move_mthd foreign key (move_mthd_id) 
        references move_mthd(move_mthd_id) on delete cascade
);
