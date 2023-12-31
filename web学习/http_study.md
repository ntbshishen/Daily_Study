**参考链接：https://developer.mozilla.org/zh-CN/docs/Web/**
# URI 的最常见形式是统一资源定位符（URL），他被称为web地址
  - 例如http：//www.example.com/path
  - *http://*是协议的名称
  - *www.example.com*是域名
# MIME类型是web用来识别不同文件类型的规范
  - 例如：image/gif 是指GIF图片
          image/png 是指png图片
    ##  设置MIME重要性
      - 很多 web 服务器使用默认的 application/octet-stream 来发送未知类型。出于一些安全原因，对于这些资源浏览器不允许设置一些自定义默认操作。
# HTTP基础
  1. HTTP概述：
    - HTTP 是一种能够获取如 HTML 这样的网络资源的 protocol(通讯协议)。它是在 Web 上进行数据交换的基础，是一种 client-server 协议，也就是说，请求通常是由像浏览器这样的接受方发起的。一个完整的 Web 文档通常是由不同的子文档拼接而成的，像是文本、布局描述、图片、视频、脚本等等。
  2. HTTP请求：
     HTTP 请求是由客户端发出的消息，用来使服务器执行动作。
     - 一个HTTP方法，一个动词(如GET，PUT，或者POST)
     - 请求目标(request target), 通常是一个URL 或者是协议。端口和域名的绝对路径，通常以请求的环境为特征。请求的格式因不同的HTTP方法而异。

     标头(Header)**todo**
  3. 跨源资源共享(CORS) 
     - 是一种基于 HTTP 头的机制，该机制通过允许服务器标示除了它自己以外的其它源（域、协议或端口），使得浏览器允许这些源访问加载自己的资源。
     - 出于安全性，浏览器限制脚本内发出的跨源HTTP请求。例如，XMLHTTPRequest和Fetch API 遵循[同源策略](#同源策略)，这意味着使用这些 API 的 Web 应用程序只能从加载应用程序的同一个域请求 HTTP 资源，除非响应报文包含了正确 CORS 响应头。

  4. HTTP协议中的数据压缩
     - 数据压缩是提高 Web 站点性能的一种重要手段。对于有些文件来说，高达 70% 的压缩比率可以大大减低对于带宽的需求。随着时间的推移，压缩算法的效率也越来越高，同时也有新的压缩算法被发明出来，应用在客户端与服务器端。
     - 在实际应用时，web 开发者不需要亲手实现压缩机制，浏览器及服务器都已经将其实现了，不过他们需要确保在服务器端进行了合理的配置。数据压缩会在三个不同的层面发挥作用：

      A.  首先某些格式的文件会采用特定的优化算法进行压缩

      B.  其次在 HTTP 协议层面会进行通用数据加密，即数据资源会以压缩的形式进行端到端传输

      C.  最后数据压缩还会发生在网络连接层面，即发生在 HTTP 连接的两个节点之间
  5. HTTP COOKIE
     - 通常，它用于告知服务端两个请求是否来自同一浏览器——如保持用户的登录状态。Cookie 使基于无状态的 HTTP 协议记录稳定的状态信息成为了可能。
     
   

## 同源策略
  1. 同源策略：
    - 是一个重要的安全策略，它用于限制一个[源](#源)的文档或者它加载的脚本如何能与另一个源的资源进行交互。
    -
## 源
  1. 源的定义：
    -如果两个 URL 的协议、端口 (en-US)（如果有指定的话）和主机都相同的话，则这两个 URL 是同源的。这个方案也被称为“协议/主机/端口元组”，或者直接是“元组”。（“元组”是指一组项目构成的整体，具有双重/三重/四重/五重等通用形式。）
