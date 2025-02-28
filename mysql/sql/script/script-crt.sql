/*crt-stat*/
create table stat (
    stat_id int not null auto_increment,
    stat_code varchar(36) unique,
    stat_name_en varchar(36),
    stat_name_ja varchar(36),
    constraint stat_pk primary key (stat_id)
);
/*crt-natu*/
create table natu (
    natu_id int not null auto_increment,
    natu_code varchar(36) unique,
    natu_name_en varchar(36),
    natu_name_ja varchar(36),
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
    egg_grp_code varchar(36) unique,
    egg_grp_name_en varchar(36),
    egg_grp_name_ja varchar(36),
    constraint egg_grp_pk primary key (egg_grp_id)
);
/*crt-egg-cyc*/
create table egg_cyc (
    egg_cyc_id int not null auto_increment,
    egg_cyc_code varchar(36) unique,
    egg_cyc_val int,
    constraint egg_cyc_pk primary key (egg_cyc_id)
);
/*crt-exp-grp*/
create table exp_grp (
    exp_grp_id int not null auto_increment,
    exp_grp_code varchar(36) unique,
    exp_grp_name_en varchar(36),
    exp_grp_name_ja varchar(36),
    exp_grp_final int,
    constraint exp_grp_pk primary key (exp_grp_id)
);
/*crt-gndr*/
create table gndr (
    gndr_id int not null auto_increment,
    gndr_code varchar(36) unique,
    gndr_name_en varchar(36),
    gndr_name_ja varchar(36),
    gndr_sym varchar(36),
    constraint gndr_pk primary key (gndr_id)
);
/*crt-abil*/
create table abil_eff_type (
    abil_eff_type_id int not null auto_increment,
    abil_eff_type_code varchar(36) unique,
    abil_eff_type_name_en varchar(1000),
    abil_eff_type_name_ja varchar(1000),
    constraint abil_eff_type_pk primary key (abil_eff_type_id)
);
create table abil_eff (
    abil_eff_id int not null auto_increment,
    abil_eff_code varchar(36) unique,
    abil_eff_desc_en varchar(1000),
    abil_eff_desc_ja varchar(1000),
    abil_eff_type_id int,
    constraint abil_eff_pk primary key (abil_eff_id),
    constraint abil_pass_eff_fk_eff_type foreign key (abil_eff_type_id) 
        references abil_eff_type(abil_eff_type_id) on delete cascade
);
create table abil (
    abil_id int not null auto_increment,
    abil_code varchar(36) unique,
    abil_name_en varchar(36),
    abil_name_ja varchar(36),
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
    type_code varchar(36) unique,
    type_name_en varchar(36),
    type_name_ja varchar(36),
    constraint type_pk primary key (type_id)
);
/*crt-move*/
create table move_cat (
    move_cat_id int not null auto_increment,
    move_cat_code varchar(36) unique,
    move_cat_name_en varchar(36),
    move_cat_name_ja varchar(36),
    constraint move_cat_pk primary key (move_cat_id)
);
create table move_eff (
    move_eff_id int not null auto_increment,
    move_eff_code varchar(36) unique,
    move_eff_desc_en varchar(1000),
    move_eff_desc_ja varchar(1000),
    constraint move_eff_pk primary key (move_eff_id)
);
create table move_trgt (
    move_trgt_id int not null auto_increment,
    move_trgt_code varchar(36) unique,
    move_trgt_name_en varchar(36),
    move_trgt_name_ja varchar(36),
    constraint move_eff_pk primary key (move_trgt_id)
);
create table move_mthd (
    move_mthd_id int not null auto_increment,
    move_mthd_code varchar(36) unique,
    move_mthd_name_en varchar(36),
    move_mthd_name_ja varchar(36),
    constraint move_mthd_pk primary key (move_mthd_id)
);
create table move_lrn (
    move_lrn_id int not null auto_increment,
    move_lrn_code varchar(36) unique,
    move_lrn_name_en varchar(36),
    move_lrn_name_ja varchar(36),
    constraint move_lrn_pk primary key (move_lrn_id)
);
create table move (
    move_id int not null auto_increment,
    move_code varchar(36) unique,
    move_name_en varchar(36),
    move_name_ja varchar(36),
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
    move_tuto_code varchar(36) unique,
    move_tuto_name_en varchar(36),
    move_tuto_name_ja varchar(36),
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
    zone_name_code varchar(36) unique,
    zone_name_en varchar(36),
    zone_name_ja varchar(36),
    constraint zone_name_pk primary key (zone_name_id)
);
create table zone (
    zone_id int not null auto_increment,
    zone_code varchar(36) unique,
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
    item_type_code varchar(36) unique,
    item_type_name_en varchar(36),
    item_type_name_ja varchar(36),
    constraint item_type_pk primary key (item_type_id)
);
create table item_pkt (
    item_pkt_id int not null auto_increment,
    item_pkt_code varchar(36) unique,
    item_pkt_name_en varchar(36),
    item_pkt_name_ja varchar(36),
    constraint item_pkt_pk primary key (item_pkt_id)
);
create table item_cat (
    item_cat_id int not null auto_increment,
    item_cat_code varchar(36) unique,
    item_cat_name_en varchar(36),
    item_cat_name_ja varchar(36),
    constraint item_cat_pk primary key (item_cat_id)
);
create table item (
    item_id int not null auto_increment,
    item_code varchar(36) unique,
    item_img varchar(36),
    item_name_en varchar(36),
    item_name_ja varchar(36),
    item_desc_en varchar(1000),
    item_desc_ja varchar(1000),
    item_price_buy_ye int,
    item_price_sel_ye int,
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
create table item_mach_obt (
    item_mach_obt_id int not null auto_increment,
    item_mach_obt_code varchar(36) unique,
    item_mach_obt_name_en varchar(36),
    item_mach_obt_name_ja varchar(36),
    constraint item_mach_obt_pk primary key (item_mach_obt_id)
);
create table item_mach (
    item_mach_id int not null,
    item_mach_num int,
    item_mach_obt_id int,
    move_id int,
    constraint item_mach_pk primary key (item_mach_id),
    constraint item_mach_fk_item foreign key (item_mach_id)
        references item(item_id) on delete cascade,
    constraint item_mach_fk_move foreign key (move_id)
        references move(move_id) on delete cascade,
    constraint item_mach_fk_item_mach_obt foreign key (item_mach_obt_id)
        references item_mach_obt(item_mach_obt_id) on delete cascade
);
/*crt-shop*/
create table curr (
    curr_id int not null auto_increment,
    curr_code varchar(36) unique,
    curr_name_en varchar(36),
    curr_name_ja varchar(36),
    constraint curr_pk primary key (curr_id)
);
create table shop (
    shop_id int not null auto_increment,
    shop_code varchar(36) unique,
    shop_name_en varchar(36),
    shop_name_ja varchar(36),
    zone_id int,
    curr_id int,
    constraint shop_pk primary key (shop_id),
    constraint shop_fk_zone foreign key (zone_id)
        references zone(zone_id) on delete cascade,
    constraint shop_fk_curr foreign key (curr_id)
        references curr(curr_id) on delete cascade
);
create table shop_sell_item (
    shop_id int not null,
    item_id int not null,
    constraint shop_sell_item_pk primary key (shop_id, item_id),
    constraint shop_sell_item_fk_shop foreign key (shop_id)
        references shop(shop_id) on delete cascade,
    constraint shop_sell_item_fk_item foreign key (item_id)
        references item(item_id) on delete cascade
);
/*crt-pd*/
create table pd (
    pd_id int not null auto_increment,
    pd_code varchar(36) unique,
    pd_index int,
    pd_name_en varchar(36),
    pd_name_ja varchar(36),
    pd_img varchar(36),
    pd_cap_rate int,
    pd_exp int, 
    pd_hap int,
    pd_base_hp int,
    pd_base_atk int,
    pd_base_def int,
    pd_base_spatk int,
    pd_base_spdef int,
    pd_base_spe int,
    egg_cyc_id int,
    exp_grp_id int,
    constraint pd_pk primary key (pd_id),
    constraint pd_fk_egg_cyc foreign key (egg_cyc_id)
        references egg_cyc(egg_cyc_id) on delete cascade,
    constraint pd_fk_exp_grp foreign key (exp_grp_id)
        references exp_grp(exp_grp_id) on delete cascade
);
create table pd_yiel_stat (
    pd_id int not null,
    stat_id int not null,
    amount int,
    constraint pd_yiel_stat_pk primary key (pd_id, stat_id),
    constraint pd_yiel_stat_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_yiel_stat_fk_stat foreign key (stat_id)
        references stat(stat_id) on delete cascade
);
create table pd_tra_abil (
    pd_id int not null,
    abil_id int not null,
    constraint pd_tra_abil_pk primary key (pd_id, abil_id),
    constraint pd_tra_abil_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_tra_abil_fk_abil foreign key (abil_id)
        references abil(abil_id) on delete cascade
);
create table pd_belo_egg_grp (
    pd_id int not null,
    egg_grp_id int not null,
    constraint pd_belo_egg_grp_pk primary key (pd_id, egg_grp_id),
    constraint pd_belo_egg_grp_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_belo_egg_grp_fk_egg_grp foreign key (egg_grp_id)
        references egg_grp(egg_grp_id) on delete cascade
);
create table pd_evok_type (
    pd_id int not null,
    type_id int not null,
    constraint pd_evok_type_pk primary key (pd_id, type_id),
    constraint pd_evok_type_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_evok_type_fk_type foreign key (type_id)
        references type(type_id) on delete cascade
);
create table pd_hold_item (
    pd_id int not null,
    item_id int not null,
    rate int,
    constraint pd_hold_item_pk primary key (pd_id, item_id),
    constraint pd_hold_item_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_hold_item_fk_item foreign key (item_id)
        references item(item_id) on delete cascade
);
create table pd_dimo_gndr (
    pd_id int not null,
    gndr_id int not null,
    rate double,
    constraint pd_dimo_gndr_pk primary key (pd_id, gndr_id),
    constraint pd_dimo_gndr_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_dimo_gndr_fk_gndr foreign key (gndr_id)
        references gndr(gndr_id) on delete cascade
);
create table pd_shif_pd (
    pd_id_ori int not null,
    pd_id_alt int not null,
    constraint pd_dimo_pd_pk primary key (pd_id_alt),
    constraint pd_dimo_pd_fk_pd_ori foreign key (pd_id_ori)
        references pd(pd_id) on delete cascade,
    constraint pd_dimo_pd_fk_pd_alt foreign key (pd_id_alt)
        references pd(pd_id) on delete cascade
);
create table evo_fam (
    evo_fam_id int not null auto_increment,
    evo_fam_code varchar(36) unique,
    evo_fam_name_en varchar(36),
    evo_fam_name_ja varchar(36),
    constraint evo_fam_pk primary key (evo_fam_id)
);
create table pd_lina_evo_fam (
    pd_id int not null,
    evo_fam_id int not null,
    ordr int,
    constraint pd_lina_evo_fam_pk primary key (pd_id, evo_fam_id),
    constraint pd_lina_evo_fam_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_lina_evo_fam_fk_evo_fam foreign key (evo_fam_id)
        references evo_fam(evo_fam_id) on delete cascade
);
create table evo_cond (
    evo_cond_id int not null auto_increment,
    evo_cond_code varchar(36) unique,
    evo_cond_desc_en varchar(1000),
    evo_cond_desc_ja varchar(1000),
    constraint evo_cond_pk primary key (evo_cond_id)
);
create table pd_evo_pd (
    pd_id_sta int not null,
    pd_id_end int not null,
    evo_cond_id int not null,
    lv int,
    constraint pd_evo_pd_pk primary key (pd_id_sta, pd_id_end, evo_cond_id),
    constraint pd_evo_pd_fk_pd_sta foreign key (pd_id_sta)
        references pd(pd_id) on delete cascade,
    constraint pd_evo_pd_fk_pd_end foreign key (pd_id_end)
        references pd(pd_id) on delete cascade,
    constraint pd_evo_pd_fk_evo_cond foreign key (evo_cond_id)
        references evo_cond(evo_cond_id) on delete cascade
);
create table pd_baby_pd (
    pd_id_pare int not null,
    pd_id_baby int not null,
    item_id int not null,
    constraint pd_baby_pd_pk primary key (pd_id_pare, pd_id_baby, item_id),
    constraint pd_baby_pd_fk_pd_pare foreign key (pd_id_pare)
        references pd(pd_id) on delete cascade,
    constraint pd_baby_pd_fk_pd_baby foreign key (pd_id_baby)
        references pd(pd_id) on delete cascade,
    constraint pd_baby_pd_fk_item foreign key (item_id)
        references item(item_id) on delete cascade
);
create table pd_lrn_move (
    pd_id int not null,
    move_id int not null,
    move_lrn_id int not null,
    lv int not null,
    constraint pd_lrn_move_pk primary key (pd_id, move_id, move_lrn_id, lv),
    constraint pd_lrn_move_fk_pd foreign key (pd_id) 
        references pd(pd_id) on delete cascade,
    constraint pd_lrn_move_fk_move foreign key (move_id) 
        references move(move_id) on delete cascade,
    constraint pd_lrn_move_fk_lrn foreign key (move_lrn_id) 
        references move_lrn(move_lrn_id) on delete cascade
);
create table item_foss (
    item_foss_id int not null,
    pd_id int,
    constraint item_foss_pk primary key (item_foss_id),
    constraint item_foss_fk_item foreign key (item_foss_id)
        references item(item_id) on delete cascade,
    constraint item_foss_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade
);
create table shop_exch_pd (
    shop_id int not null,
    pd_id int not null,
    price int,
    constraint shop_exch_pd_pk primary key (pd_id),
    constraint shop_exch_pd_fk_shop foreign key (shop_id)
        references shop(shop_id) on delete cascade,
    constraint shop_exch_pd_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade
);
/*crt-obt*/
create table vrs (
    vrs_id int not null auto_increment,
    vrs_code varchar(36) unique,
    vrs_name_en varchar(36),
    vrs_name_ja varchar(36),
    vrs_sym varchar(36),
    constraint vrs_pk primary key (vrs_id)
);
create table enc (
    enc_id int not null auto_increment,
    enc_code varchar(36) unique,
    enc_name_en varchar(36),
    enc_name_ja varchar(36),
    constraint enc_pk primary key (enc_id)
);
create table pd_spaw_hgss (
    pd_id int not null,
    zone_id int not null,
    enc_id int not null,
    is_hg bool,
    is_ss bool,
    lv_min int,
    lv_max int,
    rate_m int,
    rate_d int,
    rate_n int,
    constraint pd_spaw_hg_pk primary key (pd_id, zone_id, enc_id, is_hg, is_ss, lv_min),
    constraint pd_spaw_hg_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_spaw_hg_fk_zone foreign key (zone_id)
        references zone(zone_id) on delete cascade,
    constraint pd_spaw_hg_fk_enc foreign key (enc_id)
        references enc(enc_id) on delete cascade
);
create table item_obt (
    item_obt_id int not null auto_increment,
    item_obt_code varchar(36) unique,
    item_obt_name_en varchar(36),
    item_obt_name_ja varchar(36),
    constraint item_obt_pk primary key (item_obt_id)
);
create table item_loc_hgss (
    item_id int not null,
    zone_id int not null,
    item_obt_id int not null,
    constraint item_loc_hgss_pk primary key (item_id, zone_id, item_obt_id),
    constraint item_loc_hgss_fk_item foreign key (item_id)
        references item(item_id) on delete cascade,
    constraint item_loc_hgss_fk_zone foreign key (zone_id)
        references zone(zone_id) on delete cascade,
    constraint item_loc_hgss_fk_item_obt foreign key (item_obt_id)
        references item_obt(item_obt_id) on delete cascade
);
/*crt-saf*/
create table saf_blk (
    saf_blk_id int not null auto_increment,
    saf_blk_code varchar(36) unique,
    saf_blk_name_en varchar(36),
    saf_blk_name_ja varchar(36),
    constraint saf_blk_pk primary key (saf_blk_id)
);
create table pd_spaw_saf (
    pd_id int not null,
    zone_id int not null,
    enc_id int not null,
    saf_blk1_id int,
    saf_blk2_id int,
    lv_min int,
    lv_max int,
    amount1 int,
    amount2 int,
    days int,
    constraint pd_spaw_saf_pk primary key (pd_id, zone_id, enc_id, lv_min),
    constraint pd_spaw_saf_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pd_spaw_saf_fk_zone foreign key (zone_id)
        references zone(zone_id) on delete cascade,
    constraint pd_spaw_saf_fk_enc foreign key (enc_id)
        references enc(enc_id) on delete cascade,
    constraint pd_spaw_saf_fk_saf_blk1 foreign key (saf_blk1_id)
        references saf_blk(saf_blk_id) on delete cascade,
    constraint pd_spaw_saf_fk_saf_blk2 foreign key (saf_blk2_id)
        references saf_blk(saf_blk_id) on delete cascade
);
/*crt-pw*/
create table pw_unlc (
    pw_unlc_id int not null auto_increment,
    pw_unlc_code varchar(36) unique,
    pw_unlc_desc_en varchar(36),
    pw_unlc_desc_ja varchar(36),
    constraint pw_unlc_pk primary key (pw_unlc_id)
);
create table pw_crse (
    pw_crse_id int not null auto_increment,
    pw_crse_code varchar(36) unique,
    pw_crse_name_en varchar(36),
    pw_crse_name_ja varchar(36),
    pw_unlc_id int,
    constraint pw_crse_pk primary key (pw_crse_id),
    constraint pw_crse_fk_pw_unlc foreign key (pw_unlc_id)
        references pw_unlc(pw_unlc_id) on delete cascade
);
create table pw_grp (
    pw_grp_id int not null auto_increment,
    pw_grp_code varchar(36) unique,
    pw_grp_name_en varchar(36),
    pw_grp_name_ja varchar(36),
    constraint pw_grp_pk primary key (pw_grp_id)
);
create table pw_crse_spaw_pd (
    pd_id int not null,
    pw_crse_id int not null,
    pw_grp_id int not null,
    step int,
    constraint pw_crse_spaw_pd_pk primary key (pd_id, pw_crse_id, pw_grp_id, step),
    constraint pw_crse_spaw_pd_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint pw_crse_spaw_pd_fk_pw_crse foreign key (pw_crse_id)
        references pw_crse(pw_crse_id) on delete cascade,
    constraint pw_crse_spaw_pd_fk_pw_grp foreign key (pw_grp_id)
        references pw_grp(pw_grp_id) on delete cascade
);
create table pw_crse_loc_item (
    item_id int not null,
    pw_crse_id int not null,
    step int,
    constraint pw_crse_loc_item_pk primary key (item_id, pw_crse_id, step),
    constraint pw_crse_loc_item_fk_item foreign key (item_id)
        references item(item_id) on delete cascade,
    constraint pw_crse_loc_item_fk_pw_crse foreign key (pw_crse_id)
        references pw_crse(pw_crse_id) on delete cascade
);
/*crt-gear*/
create table npc_title (
    npc_title_id int not null auto_increment,
    npc_title_code varchar(36) unique,
    npc_title_name_en varchar(36),
    npc_title_name_ja varchar(36),
    constraint npc_title_pk primary key (npc_title_id)
);
create table npc (
    npc_id int not null auto_increment,
    npc_code varchar(36) unique,
    npc_name_en varchar(36),
    npc_name_ja varchar(36),
    npc_title_id int,
    constraint npc_pk primary key (npc_id),
    constraint npc_fk_title foreign key (npc_title_id)
        references npc_title(npc_title_id) on delete cascade
);
create table gear_time (
    gear_time_id int not null auto_increment,
    gear_time_code varchar(36) unique,
    gear_time_name_en varchar(36),
    gear_time_name_ja varchar(36),
    constraint gear_time_pk primary key (gear_time_id)
);
create table gear_day (
    gear_day_id int not null auto_increment,
    gear_day_code varchar(36) unique,
    gear_day_name_en varchar(36),
    gear_day_name_ja varchar(36),
    constraint gear_day_pk primary key (gear_day_id)
);
create table gear_call (
    gear_call_id int not null auto_increment,
    gear_call_code varchar(36) unique,
    gear_day_id int,
    gear_time_id int,
    npc_id int,    
    zone_id int,
    money int,
    constraint gear_call_pk primary key (gear_call_id),
    constraint gear_call_fk_day foreign key (gear_day_id)
        references gear_day(gear_day_id) on delete cascade,
    constraint gear_call_fk_time foreign key (gear_time_id)
        references gear_time(gear_time_id) on delete cascade,
    constraint gear_call_fk_npc foreign key (npc_id)
        references npc(npc_id) on delete cascade,
    constraint gear_call_fk_zone foreign key (zone_id)
        references zone(zone_id) on delete cascade
);
create table gear_foug_pd (
    gear_call_id int not null,
    pd_id int not null,
    lv int,
    ordr int,
    constraint gear_foug_pd_pk primary key (gear_call_id, pd_id, ordr),
    constraint gear_foug_pd_fk_gear_call foreign key (gear_call_id)
        references gear_call(gear_call_id) on delete cascade,
    constraint gear_foug_pd_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade
);
create table gear_gift_item (
    gear_call_id int not null,
    item_id int not null,
    constraint gear_gift_item_pk primary key (gear_call_id),
    constraint gear_gift_item_fk_gear_call foreign key (gear_call_id)
        references gear_call(gear_call_id) on delete cascade,
    constraint gear_gift_item_fk_item foreign key (item_id)
        references item(item_id) on delete cascade
);
/*crt-usr*/
create table usr (
    usr_id int not null auto_increment,
    usr_uuid varchar(36) unique,
    usr_name varchar(36),
    usr_pass varchar(36),
    usr_mail varchar(36),
    constraint usr_pk primary key (usr_id)
);
create table fc (
    fc_id int not null auto_increment,
    fc_code varchar(15),    
    fc_name varchar(36),
    usr_id int,
    vrs_id int,
    constraint fc_pk primary key (fc_id),
    constraint fc_fk_usr foreign key (usr_id)
        references usr(usr_id) on delete cascade,
    constraint fc_fk_vrs foreign key (vrs_id)
        references vrs(vrs_id) on delete cascade
);
/*crt-po*/
create table po (
    po_id int not null auto_increment,
    po_uuid varchar (36) unique,
    po_date_crt timestamp,
    po_date_mod timestamp,
    po_def_hp int,
    po_def_atk int,
    po_def_def int,
    po_def_spatk int,
    po_def_spdef int,
    po_def_spe int,
    po_cur_hp int,
    po_cur_atk int,
    po_cur_def int,
    po_cur_spatk int,
    po_cur_spdef int,
    po_cur_spe int,
    po_ev_hp int,
    po_ev_atk int,
    po_ev_def int,
    po_ev_spatk int,
    po_ev_spdef int,
    po_ev_spe int,
    po_is_saiko_hp bool,
    po_is_saiko_atk bool,
    po_is_saiko_def bool,
    po_is_saiko_spatk bool,
    po_is_saiko_spdef bool,
    po_is_saiko_spe bool,
    po_is_priv bool,
    pd_id int,
    usr_id int,
    abil_id int,
    natu_id int,
    gndr_id int,
    constraint po_pk primary key (po_id),
    constraint po_fk_pd foreign key (pd_id)
        references pd(pd_id) on delete cascade,
    constraint po_fk_usr foreign key (usr_id)
        references usr(usr_id) on delete cascade,
    constraint po_fk_abil foreign key (abil_id)
        references abil(abil_id) on delete cascade,
    constraint po_fk_natu foreign key (natu_id)
        references natu(natu_id) on delete cascade,
    constraint po_fk_gndr foreign key (gndr_id)
        references gndr(gndr_id) on delete cascade
);
create table po_held_item (
    po_id int not null,
    item_id int not null,
    constraint po_held_item_pk primary key (po_id),
    constraint po_held_item_fk_po foreign key (po_id)
        references po(po_id) on delete cascade,
    constraint po_held_item_fk_item foreign key (item_id)
        references item(item_id) on delete cascade
);
create table po_know_move (
    po_id int not null,
    move_id int not null,
    constraint po_know_move_pk primary key (po_id, move_id),
    constraint po_know_move_fk_po foreign key (po_id)
        references po(po_id) on delete cascade,
    constraint po_know_move_fk_move foreign key (move_id)
        references move(move_id) on delete cascade
);
/*crt-po*/
create table team (
    team_id int not null auto_increment,
    team_uuid varchar (36) unique,
    team_date_crt timestamp,
    team_date_mod timestamp,
    team_is_priv bool,
    usr_id int,
    constraint team_pk primary key (team_id),
    constraint team_fk_usr foreign key (usr_id)
        references usr(usr_id) on delete cascade
);
create table team_mem_po (
    team_id int not null,
    po_id int not null,  
    constraint team_mem_po_pk primary key (team_id, po_id),
    constraint team_mem_po_fk_team foreign key (team_id)
        references team(team_id) on delete cascade,
    constraint team_mem_po_fk_po foreign key (po_id)
        references po(po_id) on delete cascade
);
/*crt-arti*/
create table arti_type (
    arti_type_id int not null auto_increment,
    arti_type_code varchar(36),
    arti_type_name_en varchar(36),
    arti_type_name_ja varchar(36),
    constraint arti_type_pk primary key (arti_type_id)
);
create table arti (
    arti_id int not null auto_increment,
    arti_code varchar(36),
    arti_name_en varchar(36),
    arti_name_ja varchar(36),
    arti_view int,
    arti_type_id int,
    constraint arti_pk primary key (arti_id),
    constraint arti_pk_arti_type foreign key (arti_type_id)
        references arti_type(arti_type_id) on delete cascade
);
