
print('hello world')

print(3+1)

# 将我们的数据输出到文件当中
# a表示如果有文件就追加，如果没有文件就新建文件
fp = open('D:/helloPython.txt', 'a+')
print('hahahaha', file=fp)  #换行输出
# 关闭文件
#fp.close()


# 不进行换行操作的输出
print('hello','world','python')

print('hello','world','python',file=fp)
fp.close()

#ret = input('请输入数据')
#print(ret)



'''

money = 1000
s = int(input('请输入取款金额：'))
if money >= s:
    money = money - s
    print('取款成功，余额为：',money)
else:
    print('取款失败！余额为',money)
'''

# 计算1~100之间的偶数和

ret = 0
a = 0
while a <= 100:
    if a%2 == 0:
        ret += a
    a += 1
print('和为 ：', ret)

#水仙花数
for item in range(100,1000):
    ge = item % 10
    shi = item//10%10
    bai = item//100
    if ge**3 + shi**3 + bai **3 == item:
        print(item)


# 输入两个数，计算一下这两个数的和

a = input("请输入第一个数:")
b = input("请输入第二个数:")
# 下面这样智能完成字符串的拼接
print((a+b), type(a+b))

# 应该为
a = int(a)
b = int(b)
print((a+b), type(a+b))