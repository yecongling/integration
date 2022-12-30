/**
 * 框架核心
 *
 */
import {TObject} from "../system/TObject";
import {TSystem} from "../system/TSystem";
import {TIme} from "../input/TIme";
import {TClipboard} from "../system/TClipboard";
import {TLocalStorage} from "../system/TLocalStorage";
import {TTheme} from "../system/TTheme";
import {TFont} from "../graphics/TFont";
import {TEmrCanvas} from "./TEmrCanvas";
import {TPoint} from "../system/TPoint";
import {TCursors} from "./Controls";
import {TCaret} from "../system/TCaret";
import {TInterval} from "../component/TInterval";

export class TEmr extends TObject {
    /* 67682 */
    constructor() {
        super();
        /* 当前实例ID */
        this.instanceID = "";
        /* 开启debug模式 */
        this.debug = false;
        /* 暂时不知道是啥意思  后续改 ？？？？ */
        this.meaChr = false;
        /* 浏览器 */
        this.browser = this.__GetBrowserType();
        /* 系统类 */
        this.system = new TSystem();
        /* 输入法单元 */
        this.ime = new TIme();
        /* 粘贴板功能单元 */
        this.clipboard = new TClipboard();
        /* 本地存储单元 */
        this.localStorage = new TLocalStorage();
        this.__initBrushStyle();
        /* 主题 */
        this.theme = new TTheme(this);
        /* 主题上图片加载后 */
        this.theme.onImageLoad = () => {
            this.update();
        }
        /* 默认字体-67696 */
        this.defaultFont = new TFont(this);
        /* canvas */
        this.canvasTemp_ = document.createElement("canvas");
        this.contextTemp = this.canvasTemp_.getContext("2d");
        this.emrCanvasTemp = new TEmrCanvas(this.contextTemp);
        /* 下面三个不晓得干嘛的？？？？ */
        this._touchTimer = false;
        this._touchLong = false;
        this._touchPt = null;

        /* 当前应用程序控制单元 */
        this._curApplication = null;
        /* 更新次数 */
        this._updateCount = 0;
        /* 处理次数？？？  不晓得干嘛的 */
        this._handleSeq = 1000;
        /* 光标点？ */
        this._cursorPos = new TPoint();
        this._cursor = TCursors.Default;
        /* 光标控制单元 */
        this._cursorControl = null;

        /* 矩形区域 */
        this._caret = new TCaret();

        /* 干嘛的？？？？ */
        this._idle = false;
        this._idleInterval = new TInterval(500);
        this._idleInterval.loop = true;
        this._idleInterval.onExecute = ()=> {
            this._doIdle();
        }
        this._idleInterval.enabled = true;

        /* 键盘事件状态 */
        this.keyDownStates = new Array(255);

        /* 画布大小（不是里面一页文书大小） */
        this.width_ = 854;
        this.height_ = 400;
        this.left_ = this._getAdjustLeft();
        this.top_ = 0;

        /* 进入设计模式 */
        this._design = false;
        /* 聚焦状态 */
        this._focus = false;
        /* 鼠标移入状态 */
        this._mouseIn = false;
        /* 水平居中 */
        this._horizontalCenter = true;
        /* 自动宽度 */
        this._autoWidth = false;
        /* 自动高度 */
        this._autoHeight = true;

        /* 聚焦层？？ */
        this._focusLayer = null;
        /* 捕获层？？？ */
        this._captureLayer = null;
        /* 鼠标移动层？？？ */
        this._mouseMoveLayer = null;
        /* 捕获弹出层？？？ */
        this._capturePopupControl = null;
        /* 鼠标移入弹出层？？？ */
        this._mouseMovePopupControl = null;

    }

    /**
     * 获取浏览器类型
     *
     * @private
     */
    __GetBrowserType() {

    }

    /**
     * 创建光标
     *
     * @param control
     * @param image
     * @param width
     * @param height
     * @private
     */
    __createCaret(control, image, width, height) {

    }

    /**
     * b不晓得啥作用 先写到
     *
     * @private
     */
    __initBrushStyle() {

    }

    /**
     * 更新
     *
     */
    update() {

    }

    /**
     * 定时器执行（大多是用作光标的闪烁）
     *
     * @private
     */
    _doIdle() {

    }

    /**
     * 获取调整左边距
     *
     * @private
     */
    _getAdjustLeft() {

    }
}