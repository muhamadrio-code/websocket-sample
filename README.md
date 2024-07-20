## Intro

WebSocket is a communication protocol that provides full-duplex communication channels over a single, long-lived TCP connection. Unlike traditional HTTP, which follows a request-response pattern, WebSocket allows for real-time, bi-directional communication between a client and a server. This means that data can be sent and received simultaneously, making it ideal for applications requiring real-time updates such as chat applications, live sports scores, stock tickers, and collaborative editing tools. WebSocket connections are established via an HTTP handshake, and once established, data can be exchanged with low latency and minimal overhead, enhancing the performance and responsiveness of web applications.

![websocket diagram](/docs/websocket-diagram.png "websocket diagram")

## Pre-requisite
- Java 17
- maven
- SpringBoot 3.3.2
- Spring WebSocket
- SockJS
- STOMP

## Clone Project
```bash
git clone https://github.com/muhamadrio-code/websocket-sample.git
```