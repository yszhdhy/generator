#userLayout {
  margin: 0;
  padding: 0;
  background-image: url("@/assets/images/login_background.jpg");
  background-size: cover;
  width: 100vw;
  height: 100vh;
  position: relative;
  .input-icon {
    padding-right: 6px;
    padding-top: 4px;
  }
  .login_panel {
    position: absolute;
    top: 3vh;
    left: 2vw;
    width: 96vw;
    height: 94vh;
    background-color: rgba(255, 255, 255, .8);
    border-radius: 10px;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    .login_panel_right {
      background-image: url("@/assets/images/login_left.svg");
      background-size: cover;
      width: 40%;
      height: 60%;
      float: right !important;
    }
    .login_panel_form {
      width: 600px;
      background-color: #fff;
      padding: 40px 40px 40px 40px;
      border-radius: 10px;
      box-shadow: 2px 3px 7px rgba(0, 0, 0, .2);
      .login_panel_form_title {
        display: flex;
        align-items: center;
        margin: 30px 0;
        .login_panel_form_title_logo {
          width: 90px;
          height: 72px;
        }
        .login_panel_form_title_p {
          font-size: 35px;
          font-family: Algerian;
          padding-left: 50px;
        }
      }
      .vPicBox {
        display: flex;
        justify-content: space-between;
        width: 100%;
      }
      .vPic {
        width: 33%;
        height: 38px;
        background: #ccc;
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
    }
    .login_panel_foot {
      position: absolute;
      bottom: 20px;
      .links {
        display: flex;
        align-items: center;
        justify-content: space-between;
        .link-icon {
          width: 30px;
          height: 30px;
        }
      }
      .copyright {
        color: #777777;
        margin-top: 5px;
      }
    }
  }
}

//小屏幕不显示右侧，将登录框居中
@media (max-width: 750px) {
  .login_panel_right {
    display: none;
  }
  .login_panel {
    width: 100vw;
    height: 100vh;
    top: 0;
    left: 0;
  }
  .login_panel_form {
    width: 100%;
  }
}


