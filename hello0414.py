# coding=utf-8
import time

from selenium import webdriver
from selenium.webdriver.common.keys import Keys

drive = webdriver.Firefox()
drive.get("http://www.baidu.com")
drive.maximize_window()

drive.find_element_by_id("kw").send_keys("撒贝宁")
drive.find_element_by_id("su").click()
drive.implicitly_wait(10)
drive.find_element_by_link_text("撒贝宁 - 百度百科").click()
drive.set_window_size(400, 800)
time.sleep(6)
drive.maximize_window()

# 元素的定位------------------------------------------------------

# drive.find_element_by_id("kw").send_keys("三十而已")
# drive.find_element_by_id("su").click()

# drive.find_element_by_name("wd").send_keys("三十而已")

# 不能成功，因为input太多了不唯一
# drive.find_element_by_tag_name("input").send_keys("三十而已")

# drive.find_element_by_class_name("s_ipt").send_keys("三十而已")

# drive.find_element_by_xpath("//*[@id='kw']").send_keys("三十而已")

# drive.find_element_by_css_selector("#kw").send_keys("三十而已")
# drive.find_element_by_css_selector("#su").click()

# drive.find_element_by_link_text(u"视频").click()  #u是因为是汉字 u"视频"是个链接


# 先输入三十而已，再清除，在输入二十不惑-----------------------------------
# drive.find_element_by_id("kw").send_keys("三十而已")
# drive.find_element_by_id("su").click()
# time.sleep(3)
# drive.find_element_by_id("kw").clear()  #清除
# time.sleep(3)
# drive.find_element_by_id("kw").send_keys("二十不惑")
# drive.find_element_by_id("su").click()

# submit() 可以代替 click() 但是必须要在检查的时候能看到submit属性
# drive.find_element_by_id("su").click()
# drive.find_element_by_id("su").submit()

# 输出文本信息
# text = drive.find_element_by_id("s-bottom-layer-right").text
# print("test : " + text)
# drive.find_element_by_id("kw").send_keys("二十不惑")
# drive.find_element_by_id("su").click()
# text = drive.find_element_by_class_name("s_tab_inner").text
# print("test :" + text)

# 等待
# time.sleep(2) # 固定等待  设置几秒钟就等待几秒钟
# drive.implicitly_wait(2) # 只能等待，如果界面加载好了就直接不等待了

# drive.find_element_by_id("kw").send_keys("三十而已")
# drive.find_element_by_id("su").click()
# drive.implicitly_wait(10) #只能等待
# drive.find_element_by_link_text(u"三十而已(2020年张晓波执导的电视剧)_百度百科").click()

# 打印
# print(drive.title)
# print(drive.current_url)

# 参数数字为像素点
# print("设置浏览器宽480、高800显示")
# drive.set_window_size(480, 800)


drive.find_element_by_id("kw").send_keys("二十不惑")
drive.find_element_by_id("su").click()
time.sleep(3)
# 将页面滚动条拖到底部
# js = "var q=document.documentElement.scrollTop=10000"
# drive.execute_script(js)
# time.sleep(3)
# 将滚动条移动到页面的顶部
# js0 = "var q=document.documentElement.scrollTop=0"
# drive.execute_script(js0)
# 同时控制浏览器左右上下
js2 = "window.scrollTo(200,200)"
drive.execute_script(js2)


# 键盘组合键-------------------------------------------------------------
# 输入框输入内容
# drive.find_element_by_id("kw").send_keys("selenium")
# time.sleep(3)
# ctrl+a 全选输入框内容
# drive.find_element_by_id("kw").send_keys(Keys.CONTROL,'a')
# time.sleep(3)
# ctrl+x 剪切输入框内容
# drive.find_element_by_id("kw").send_keys(Keys.CONTROL,'x')
# time.sleep(3)
# 输入框重新输入内容，搜索
# drive.find_element_by_id("kw").send_keys("webdriver")
# drive.find_element_by_id("su").click()

time.sleep(10)
drive.quit()