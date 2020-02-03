<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>MelaPortal</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A premium admin dashboard template by Mannatthemes" name="description" />
        <meta content="Mannatthemes" name="author" />

        <!-- App favicon -->
        <link rel="shortcut icon"  type="image/ico"  href="<%=request.getContextPath()%>/static/assets/images/favicon.ico"/>

        <!-- App css -->
        <link href="<%=request.getContextPath()%>/static/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/metisMenu.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/style.css" rel="stylesheet" type="text/css" />

    </head>

    <body class="account-body accountbg">

        <!-- Log In page -->
        <div class="row vh-100 ">
            <div class="col-lg-12  pr-0 align-self-center">
                <div class="row">
                    <div class="col-lg-3 mx-auto">
                        <div class="card auth-card shadow-lg">
                            <div class="card-body">
                            
                                <div class="px-3">
                                    <div class="auth-logo-box">
                                        <a href="#" class="logo logo-admin"><img src="<%=request.getContextPath()%>/static/assets/images/InternPlatformlogo32.jpg" alt="logo" class="auth-logo"></a>
                                    </div><!--end auth-logo-box-->
                                    
                                  <!--   <div class="text-center auth-logo-text">
                                        <h4 class="mt-0 mb-3 mt-5">Let's Get Started AirOpcenter</h4>
                                        <p class="text-muted mb-0">Sign in to continue to AirOpcenter.</p>  
                                    </div> --> <!--end auth-logo-text-->  

           						    <form class="form-horizontal auth-form my-4" method="post" action="${pageContext.request.contextPath}/user/loginVerify" class="form">
                                        <div class="form-group">
                                            <label for="username">Username</label>
                                            <div class="input-group mb-3">
                                                <span class="auth-form-icon">
                                                    <i class="dripicons-user"></i> 
                                                </span>                                                                                                              
                                                <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter username" autocomplete="off">
                                            </div>                                    
                                        </div><!--end form-group--> 
            
                                        <div class="form-group">
                                            <label for="userpassword">Password</label>                                            
                                            <div class="input-group mb-3"> 
                                                <span class="auth-form-icon">
                                                    <i class="dripicons-lock"></i> 
                                                </span>                                                       
                                                <input type="password" class="form-control" id="userpassword" name="password" placeholder="Enter password">
                                            </div>                               
                                        </div><!--end form-group--> 
            <!-- 
                                        <div class="form-group row mt-4">
                                            <div class="col-sm-6">
                                                <div class="custom-control custom-switch switch-success">
                                                    <input type="checkbox" class="custom-control-input" id="customSwitchSuccess">
                                                    <label class="custom-control-label text-muted" for="customSwitchSuccess">Remember me</label>
                                                </div>
                                            </div>	end col 
                                            <div class="col-sm-6 text-right">
                                                <a href="auth-recover-pw.html" class="text-muted font-13"><i class="dripicons-lock"></i> Forgot password?</a>                                    
                                            </div>  end col 
                                        </div>   end form-group  
             -->
                                        <div class="form-group mb-0 row">
                                            <div class="col-12 mt-2">
                                                <button class="btn btn-primary btn-round btn-block waves-effect waves-light" type="submit">Log In <i class="fas fa-sign-in-alt ml-1"></i></button>
                                            </div><!--end col--> 
                                        </div> <!--end form-group-->                           
                                    </form><!--end form-->
                                </div><!--end /div-->
                                
                               <!--  <div class="m-3 text-center text-muted">
                                    <p class="">Don't have an account ?  <a href="../authentication/auth-register.html" class="text-primary ml-2">Free Resister</a></p>
                                </div> -->
                            </div><!--end card-body-->
                        </div><!--end card-->
                        <!-- <div class="account-social text-center mt-4">
                            <h6 class="my-4">Or Login With</h6>
                            <ul class="list-inline mb-4">
                                <li class="list-inline-item">
                                    <a href="" class="">
                                        <i class="fab fa-facebook-f facebook"></i>
                                    </a>                                    
                                </li>
                                <li class="list-inline-item">
                                    <a href="" class="">
                                        <i class="fab fa-twitter twitter"></i>
                                    </a>                                    
                                </li>
                                <li class="list-inline-item">
                                    <a href="" class="">
                                        <i class="fab fa-google google"></i>
                                    </a>                                    
                                </li>
                            </ul>
                        </div>end account-social -->
                    </div><!--end col-->
                </div><!--end row-->
            </div><!--end col-->           
        </div><!--end row-->
        <!-- End Log In page -->
    

        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/static/assets/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/bootstrap.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/waves.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/jquery.slimscroll.min.js"></script>

        <!-- App js -->
        <script src="<%=request.getContextPath()%>/static/assets/js/app.js"></script>

    </body>
</html>