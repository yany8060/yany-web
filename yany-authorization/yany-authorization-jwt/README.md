## JWT

### JWT简介
1. JWT(json web token)是为了在网络应用环境间传递声明而执行的一种基于JSON的开放标准。
2. JWT的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源。比如用在用户登录上。

### JWT结构
JWT包含了使用.分隔的三部分： Header 头部 Payload 负载 Signature 签名
* Header: 在header中通常包含了两部分：token类型和采用的加密算法。{ "alg": "HS256", "typ": "JWT"} 接下来对这部分内容使用 Base64Url 编码组成了JWT结构的第一部分。
* Payload: Token的第二部分是负载，它包含了claim， 
    * Claim是一些实体（通常指的用户）的状态和额外的元数据，有三种类型的claim：reserved, public 和 private。
    * Reserved claims: 这些claim是JWT预先定义的，在JWT中并不会强制使用它们，而是推荐使用，常用的有 iss（签发者）,exp（过期时间戳）, sub（面向的用户）, aud（接收方）, iat（签发时间）。 
    * Public claims：根据需要定义自己的字段，注意应该避免冲突 
    * Private claims：这些是自定义的字段，可以用来在双方之间交换信息 负载使用的例子：{ "sub": "1234567890", "name": "John Doe", "admin": true} 上述的负载需要经过Base64Url编码后作为JWT结构的第二部分。
        ```
        Payload(荷载)
        { "iss": "Online JWT Builder", 
          "iat": 1416797419, 
          "exp": 1448333419, 
          "aud": "www.example.com", 
          "sub": "jrocket@example.com", 
          "GivenName": "Johnny", 
          "Surname": "Rocket", 
          "Email": "jrocket@example.com", 
          "Role": [ "Manager", "Project Administrator" ] 
        }
        iss: 该JWT的签发者，是否使用是可选的；
        sub: 该JWT所面向的用户，是否使用是可选的；
        aud: 接收该JWT的一方，是否使用是可选的；
        exp(expires): 什么时候过期，这里是一个Unix时间戳，是否使用是可选的；
        iat(issued at): 在什么时候签发的(UNIX时间)，是否使用是可选的；
        其他还有：
        nbf (Not Before)：如果当前时间在nbf里的时间之前，则Token不被接受；一般都会留一些余地，比如几分钟；，是否使用是可选的；
        ```
* 签名: 将上面的两个编码后的字符串都用句号.连接在一起（头部在前）。最后，我们将上面拼接完的字符串用HS256算法进行加密。在加密的时候，我们还需要提供一个密钥（secret）。最后将这一部分签名也拼接在被签名的字符串后面，我们就得到了完整的JWT。



