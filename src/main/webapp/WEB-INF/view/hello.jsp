<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安灯系统看板</title>

<style type="text/css">

   body{
      margin:0;
      padding:0;
   }
   div.title{
      height: 100px;
      font-size: 50px;
      text-align: center;
      padding: 10px 0;
      border-bottom: 2px solid black;
      line-height: 100px;
   }
   div.warp{
      width:100%;
      margin:0;
   }
   div.panel-status{
      width: 25%;
      float: left;
      border-right: 2px solid black;
      box-sizing: border-box;
   }
   ul {
      margin:0;
      padding:0;
   }
   ul li {
      list-style:none;
      margin:0;
      padding:0;
      position:relative;
      height:120px;
   }
   div.status-icon{
        height: 80px;
        width: 80px;
        margin: auto;
        line-height: 80px;
        border-radius: 50px;
        background: green;
        margin: -top:10px;
        margin-top: 10px;
        color: white;
        text-align: center;
        font-size: 33px;
        font-weight: bold;
   }
   i.item-line{
        position:absolute;
        right:50px;
        left:50px;
        top:40px;
        border:0.5px solid red;
   }

   div.item-stauts{
       position: absolute;
       color: white;
       text-align: center;
       top: 15px;
       z-index: 10;
   }

    div.item-stauts label{
        color:black;
        font-weight: bold;
        font-size: 14px;
    }

   div.item-stauts-fault{
        left: 22px;
   }
   div.item-stauts-fault div{
        box-shadow: 0px 0px 43px #8A7171;
        width: 50px;
        height: 50px;
        line-height: 50px;
        border-radius: 50px;
        background-color: red;
        margin:auto;
   }

   div.item-stauts-ing{
       left: 50%;
       margin-left:-40px;
  }

  div.item-stauts-ing div{
       box-shadow: 0px 0px 43px #8A7171;
       width: 50px;
       height: 50px;
       line-height: 50px;
       border-radius: 50px;
       background-color: orange;
       margin:auto;
   }

  div.item-stauts-complete{
      right: 22px;
  }

  div.item-stauts-complete div{
     box-shadow: 0px 0px 43px #8A7171;
     width: 50px;
     height: 50px;
     line-height: 50px;
     border-radius: 50px;
     background-color: green;
     margin:auto;
  }

</style>

</head>
<body>
    <div class="warp">
        <div class="title">安灯系统看板</div>
        <div class="content">
            <div class="panel-status">
                <div class="status-icon">正常</div>
                <ul>
                    <c:foreach items="${device.eventDatas}" var="item">
                        <li>
                            <c:foreach items="${item.value}" var="itemEvent">
                                <div class="item-stauts item-stauts-fault">
                                    <div>故障${itemEvent.id}</div>
                                    <label>${itemEvent.createTime }</label>
                                </div>
                            </c:foreach>
                            <i class="item-line"></i>
                        </li>
                    </c:foreach>
                </ul>
            </div>
            <div class="panel-status">
                <div class="status-icon">正常</div>
                <ul>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                </ul>
            </div>
            <div class="panel-status">
                <div class="status-icon">正常</div>
                <ul>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                </ul>
            </div>
            <div class="panel-status">
                <div class="status-icon">正常</div>
                <ul>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                    <li>
                        <div class="item-stauts item-stauts-fault">
                            <div>故障</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-ing">
                            <div>处理</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <div class="item-stauts item-stauts-complete">
                            <div>完成</div>
                            <label>2017-07-01</br> 10:30:25</label>
                        </div>
                        <i class="item-line"></i>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>