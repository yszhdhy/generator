#app {

  .main-container {
    min-height: 100%;
    transition: margin-left .28s;
    margin-left: $sideBarWidth;
    position: relative;
  }

  .sidebar-container {
    transition: width 0.28s;
    width: $sideBarWidth !important;
    background-color: $menuBg;
    height: 100%;
    position: fixed;
    font-size: 0px;
    top: 0;
    bottom: 0;
    left: 0;
    z-index: 1001;
    overflow: hidden;

    // reset element-ui css
    .horizontal-collapse-transition {
      transition: 0s width ease-in-out, 0s padding-left ease-in-out, 0s padding-right ease-in-out;
    }

    .scrollbar-wrapper {
      overflow-x: hidden !important;
    }

    .el-scrollbar__bar.is-vertical {
      right: 0px;
    }

    .el-scrollbar {
      height: 100%;
    }

    &.has-logo {
      .el-scrollbar {
        height: calc(100% - 50px);
      }
    }

    .is-horizontal {
      display: none;
    }

    a {
      display: inline-block;
      width: 100%;
      overflow: hidden;
    }

    .svg-icon {
      margin-right: 16px;
    }

    .sub-el-icon {
      margin-right: 12px;
      margin-left: -2px;
    }

    .el-menu {
      border: none;
      height: 100%;
      width: 100% !important;
    }

    // menu hover
    .submenu-title-noDropdown,
    .el-submenu__title {
      &:hover {
        background-color: $menuHover !important;
      }
    }

    .is-active>.el-submenu__title {
      color: $subMenuActiveText !important;
    }

    & .nest-menu .el-submenu>.el-submenu__title,
    & .el-submenu .el-menu-item {
      min-width: $sideBarWidth !important;
      background-color: $subMenuBg !important;

      &:hover {
        background-color: $subMenuHover !important;
      }
    }
  }

  .hideSidebar {
    .sidebar-container {
      width: 54px !important;
    }

    .main-container {
      margin-left: 54px;
    }

    .submenu-title-noDropdown {
      padding: 0 !important;
      position: relative;

      .el-tooltip {
        padding: 0 !important;

        .svg-icon {
          margin-left: 20px;
        }

        .sub-el-icon {
          margin-left: 19px;
        }
      }
    }

    .el-submenu {
      overflow: hidden;

      &>.el-submenu__title {
        padding: 0 !important;

        .svg-icon {
          margin-left: 20px;
        }

        .sub-el-icon {
          margin-left: 19px;
        }

        .el-submenu__icon-arrow {
          display: none;
        }
      }
    }

    .el-menu--collapse {
      .el-submenu {
        &>.el-submenu__title {
          &>span {
            height: 0;
            width: 0;
            overflow: hidden;
            visibility: hidden;
            display: inline-block;
          }
        }
      }
    }
  }

  .el-menu--collapse .el-menu .el-submenu {
    min-width: $sideBarWidth !important;
  }

  // mobile responsive
  .mobile {
    .main-container {
      margin-left: 0px;
    }

    .sidebar-container {
      transition: transform .28s;
      width: $sideBarWidth !important;
    }

    &.hideSidebar {
      .sidebar-container {
        pointer-events: none;
        transition-duration: 0.3s;
        transform: translate3d(-$sideBarWidth, 0, 0);
      }
    }
  }

  .withoutAnimation {

    .main-container,
    .sidebar-container {
      transition: none;
    }
  }
}

// when menu collapsed
.el-menu--vertical {
  &>.el-menu {
    .svg-icon {
      margin-right: 16px;
    }
    .sub-el-icon {
      margin-right: 12px;
      margin-left: -2px;
    }
  }

  .nest-menu .el-submenu>.el-submenu__title,
  .el-menu-item {
    &:hover {
      // you can use $subMenuHover
      background-color: $menuHover !important;
    }
  }

  // the scroll bar appears when the subMenu is too long
  >.el-menu--popup {
    max-height: 100vh;
    overflow-y: auto;

    &::-webkit-scrollbar-track-piece {
      background: #d3dce6;
    }

    &::-webkit-scrollbar {
      width: 6px;
    }

    &::-webkit-scrollbar-thumb {
      background: #99a9bf;
      border-radius: 20px;
    }
  }
}
