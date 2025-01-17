drop table if exists aux_pd_baby_pd;
create temporary table aux_pd_baby_pd (
    pd_name_pare varchar(32),
    pd_name_baby varchar(32),
    item_name varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-baby-pd.csv'
into table aux_pd_baby_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name_pare,
pd_name_baby,
item_name
);

delimiter &&
drop procedure if exists proc_insrt_pd_baby_pd;
create procedure proc_insrt_pd_baby_pd()
begin
	declare i int default 1;

    declare idPdPare int default 0;
    declare idPdBaby int default 0;
    declare idItem int default 0;

    /*cur1 variables*/
    declare vPdNamePare varchar(32) default '';
    declare vPdNameBaby varchar(32) default '';
    declare vItemName varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_baby_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_baby_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdNamePare,
            vPdNameBaby,
            vItemName;

        set idPdPare = 0;
        set idPdBaby = 0;
        set idItem = 0;

        if continueCur1 = 1 then
            select pd_id into idPdPare 
                from pd 
                where pd_name_en = vPdNamePare;

            select pd_id into idPdBaby 
                from pd 
                where pd_name_en = vPdNameBaby;

            select item_id into idItem 
                from item 
                where item_name_en = vItemName;

            insert into pd_baby_pd (
                pd_id_pare,
                pd_id_baby,
                item_id                
            ) values (
                idPdPare,
                idPdBaby,
                idItem
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_baby_pd;
end
&&
delimiter ;
call proc_insrt_pd_baby_pd();
