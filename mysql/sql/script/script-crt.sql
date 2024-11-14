/*crt-stat*/
create table stat (
    stat_id int not null auto_increment,
    stat_code varchar(32) unique,
    stat_name_en varchar(32),
    stat_name_ja varchar(32),
    constraint stat_pk primary key (stat_id)
);
/*crt-natu*/
create table natu (
    natu_id int not null auto_increment,
    natu_code varchar(32) unique,
    natu_name_en varchar(32),
    natu_name_ja varchar(32),
    stat_id_red int,
    stat_id_blue int,
    constraint natu_pk primary key (natu_id),
    constraint natu_id_fk_red foreign key (stat_id_red) 
        references stat(stat_id) on delete cascade,
    constraint natu_id_fk_blue foreign key (stat_id_blue) 
        references stat(stat_id) on delete cascade
);
/*crt-egg-grp*/
create table egg_grp (
    egg_grp_id int not null auto_increment,
    egg_grp_code varchar(32) unique,
    egg_grp_name_en varchar(32),
    egg_grp_name_ja varchar(32),
    constraint egg_grp_pk primary key (egg_grp_id)
);
/*crt-exp-grp*/
create table exp_grp (
    exp_grp_id int not null auto_increment,
    exp_grp_code varchar(32) unique,
    exp_grp_name_en varchar(32),
    exp_grp_name_ja varchar(32),
    exp_grp_final int,
    constraint exp_grp_pk primary key (exp_grp_id)
);
/*crt-gndr*/
create table gndr (
    gndr_id int not null auto_increment,
    gndr_code varchar(32) unique,
    gndr_name_en varchar(32),
    gndr_name_ja varchar(32),
    gndr_sym varchar(32),
    constraint gndr_pk primary key (gndr_id)
);
/*crt-abil*/
create table abil_eff_type (
    abil_eff_type_id int not null auto_increment,
    abil_eff_type_code varchar(32) unique,
    abil_eff_type_name_en varchar(1000),
    abil_eff_type_name_ja varchar(1000),
    constraint abil_eff_type_pk primary key (abil_eff_type_id)
);
create table abil_eff (
    abil_eff_id int not null auto_increment,
    abil_eff_code varchar(32) unique,
    abil_eff_desc_en varchar(1000),
    abil_eff_desc_ja varchar(1000),
    abil_eff_type_id int,
    constraint abil_eff_pk primary key (abil_eff_id),
    constraint abil_pass_eff_fk_eff_type foreign key (abil_eff_type_id) 
        references abil_eff_type(abil_eff_type_id) on delete cascade
);
create table abil (
    abil_id int not null auto_increment,
    abil_code varchar(32) unique,
    abil_name_en varchar(32),
    abil_name_ja varchar(32),
    /*
    reverse condition on all except mold breaker
    affected by trace -> true
    affected by mold  -> false
    unused
        Doodle
        Receive & Power of Alchemy	
        Entrainment
        Wandering Spirit
        Turboblaze Teravolt
        
    */
    abil_is_role bool,
    abil_is_rece bool,
    abil_is_entr bool,
    abil_is_trac bool,
    abil_is_sksw bool,
    abil_is_gast bool,
    abil_is_mold bool,
    abil_is_tran bool,
    constraint abil_pk primary key (abil_id)
);
create table abil_pass_eff (
    abil_id int not null,
    abil_eff_id int not null,
    constraint abil_pass_eff_pk primary key (abil_id, abil_eff_id),
    constraint abil_pass_eff_fk_abil foreign key (abil_id) 
        references abil(abil_id) on delete cascade,
    constraint abil_pass_eff_fk_eff foreign key (abil_eff_id) 
        references abil_eff(abil_eff_id) on delete cascade
); 
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
create table move_lrn (
    move_lrn_id int not null auto_increment,
    move_lrn_code varchar(32) unique,
    move_lrn_name_en varchar(32),
    move_lrn_name_ja varchar(32),
    constraint move_lrn_pk primary key (move_lrn_id)
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
create table move_tuto (
    move_tuto_id int not null auto_increment,
    move_tuto_code varchar(32) unique,
    move_tuto_name_en varchar(32),
    move_tuto_name_ja varchar(32),
    constraint move_tuto_pk primary key (move_tuto_id)
);
create table move_remembered_tuto (
    move_id int not null,
    move_tuto_id int not null,
    bp int,
    constraint move_remembered_tuto_pk primary key (move_id),
    constraint move_remembered_tuto_fk_move foreign key (move_id) 
        references move(move_id) on delete cascade,
    constraint move_remembered_tuto_fk_tuto foreign key (move_tuto_id) 
        references move_tuto(move_tuto_id) on delete cascade
);
/*crt-zone*/
create table zone_name (
    zone_name_id int not null auto_increment,
    zone_name_code varchar(32) unique,
    zone_name_en varchar(32),
    zone_name_ja varchar(32),
    constraint zone_name_pk primary key (zone_name_id)
);
create table zone (
    zone_id int not null auto_increment,
    zone_code varchar(32) unique,
    zone_name_id int,
    zone_main_id int,
    constraint zone_pk primary key (zone_id),
    constraint zone_fk_main_zone_name foreign key (zone_name_id) 
        references zone_name(zone_name_id) on delete cascade,
    constraint zone_fk_main_zone foreign key (zone_main_id) 
        references zone(zone_id) on delete cascade
);
/*crt-item*/
create table item_type (
    item_type_id int not null auto_increment,
    item_type_code varchar(32) unique,
    item_type_name_en varchar(32),
    item_type_name_ja varchar(32),
    constraint item_type_pk primary key (item_type_id)
);
create table item_pkt (
    item_pkt_id int not null auto_increment,
    item_pkt_code varchar(32) unique,
    item_pkt_name_en varchar(32),
    item_pkt_name_ja varchar(32),
    constraint item_pkt_pk primary key (item_pkt_id)
);
create table item_cat (
    item_cat_id int not null auto_increment,
    item_cat_code varchar(32) unique,
    item_cat_name_en varchar(32),
    item_cat_name_ja varchar(32),
    constraint item_cat_pk primary key (item_cat_id)
);
create table item (
    item_id int not null auto_increment,
    item_code varchar(32) unique,
    item_img varchar(32),
    item_name_en varchar(32),
    item_name_ja varchar(32),
    item_desc_en varchar(1000),
    item_desc_ja varchar(1000),
    item_price_buy int,
    item_price_sell int,
    item_price_buy_bp int,
    item_price_buy_cn int,
    item_price_buy_ap int,
    item_flin int,
    item_type_id int,
    item_pkt_id int,
    item_cat_id int,
    constraint item_pk primary key (item_id),
    constraint item_fk_type foreign key (item_type_id) 
        references item_type(item_type_id) on delete cascade,
    constraint item_fk_pkt foreign key (item_pkt_id) 
        references item_pkt(item_pkt_id) on delete cascade,
    constraint item_fk_cat foreign key (item_cat_id) 
        references item_cat(item_cat_id) on delete cascade
);
create table item_mach (
    item_mach_id int not null,
    item_mach_is_num int,
    item_mach_is_hm bool,
    move_id int,
    constraint item_mach_pk primary key (item_mach_id),
    constraint item_mach_fk_item foreign key (item_mach_id)
        references item(item_id) on delete cascade,
    constraint item_mach_fk_move foreign key (move_id)
        references move(move_id) on delete cascade
);
/*crt-pd-todo*/
create table pd (
    pd_id int not null auto_increment,
    TODO varchar(32),
    constraint pd_pk primary key (pd_id)
);
create table po (
    po_id int not null auto_increment,
    TODO varchar(32),
    constraint pd_pk primary key (po_id)
);
create table pd_learns_move (
    pd_id int not null,
    move_id int not null,
    move_lrn_id int not null,
    lv int,
    constraint pd_learns_move_pk primary key (pd_id, move_id, move_lrn_id),
    constraint pd_learns_move_fk_pd foreign key (pd_id) 
        references pd(pd_id) on delete cascade,
    constraint pd_learns_move_fk_move foreign key (move_id) 
        references move(move_id) on delete cascade,
    constraint pd_learns_move_fk_lrn foreign key (move_lrn_id) 
        references move_lrn(move_lrn_id) on delete cascade
);
