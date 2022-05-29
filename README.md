# 测试

依次开启pos-discovery、pos-gateway、pos-products和pos-carts，并打开 localhost:8761：

![](https://www.png8.com/imgs/2022/04/23/5bcac874eb5713bc.png)

可以看到，各个微服务都已经正确注册。

使用postman进行HTTP请求，gateway的地址为 localhost:8080

![](https://www.png8.com/imgs/2022/04/23/42fee03a89cd8027.png)

GET方法`/products`可以得到所有的产品信息。

![](https://www.png8.com/imgs/2022/04/23/3a76c48995438cbb.png)

GET方法`/prodtcts/{productID}`可以得到某一个具体的产品信息

![](https://www.png8.com/imgs/2022/04/23/285c6b78a54c1a9c.png)

POST方法`/cart/{productID}`可以像购物车中添加产品，并返回当前购物车内容

![](https://www.png8.com/imgs/2022/04/23/00a063ce836d3e15.png)

GET方法`/cart`可以获取当前购物车所有内容

再进行一次添加产品，结果如下：

![](https://www.png8.com/imgs/2022/04/23/c8961fa25c078519.png)

![](https://www.png8.com/imgs/2022/04/23/29ba084cf3827294.png)

