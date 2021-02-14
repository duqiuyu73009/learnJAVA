create table exam_result (
     id int,
     name varchar(20),
     chinese decimal(3, 1),
     math decimal(3, 1),
     english decimal(3, 1)
     );     

insert into exam_result values
	(1, '唐三藏', 22, 44, 66),
	(2, '白龙马', 89.6, 56.7, 34.8),
	(3, '孙悟空', 67.9, 48, 78),
	(5, '猪八戒', 25.6, 41, 66),
	(1, '沙和尚', 27, 98, 45);

create table books (
    id int,
    book varchar(20),
    author varchar(20), 
    price decimal(3, 1),
    time int
);

insert into books values
	(1, '假如给我三天光明', '海伦凯勒', 36.8, 4),
	(1, '钢铁是怎样炼成的', '奥斯特罗夫斯基', 56.9, 7),
	(1, '小王子', '圣埃克苏佩里', 23.9, 7),
	(1, '文化苦旅', '余秋雨', 36.8, 7),
	(1, '千年一叹', '余秋雨', 56.9, 8),
	(1, '白夜行', '东野圭吾', 36.8, 6),
	(1, '谁杀了他', '东野圭吾', 36.8, 3),
	(1, '解忧杂货铺', '东野圭吾', 23.9, 10),
	(1, '青草地上落满花瓣','读者', 22.4, 3),
	(1, '世说新语', '刘庆义', 76.9, 2);

