/**
 * canvas绘制单元
 *
 */
import {TPen} from "../graphics/TPen";
import {TStack} from "../system/TStack";
import {TBrush} from "../graphics/TBrush";
import {TFont} from "../graphics/TFont";
import {TPoint} from "../system/TPoint";

/* canvas状态 */
let TCanvasStates = {
    FontValid: 1,
    PenValid: 2,
    BrushValid: 3
}

export class TEmrCanvas {
    /* 3572 */
    constructor(h5Context) {
        /* canvas画板的上下文 */
        this.h5Context = h5Context;
        /* 缩放大小 */
        this._scale = 1;
        /* 画板状态 */
        this._states = new Set([]);
        /* 是lineTo时的第一个点吗 */
        this._pFirst = false;
        /* 开始位置 */
        this._px1 = -1;
        this._py1 = -1;
        /* 结束位置 */
        this._px2 = -1;
        this._py2 = -1;
        /* 宽度 */
        this._pyWidth = 0;
        /* 绘制工具笔 */
        this.pen = new TPen();
        this.pen.onChange = () => {
            this._penChanged();
        }
        /* 画笔操作记录 */
        this._penStack = new TStack();
        /* 字体栈操作 */
        this._fontStack = new TStack();
        /* 不晓得干嘛的 ？？？？ */
        this.gradientBrush = null;
        /* 格式刷？？？ */
        this.brush = new TBrush();
        this.brush.onChange = () => {
            this._brushChanged();
        }
        this.brush.onColorChange = ()=> {
            this._brushChanged();
        }
        /* 字体 */
        this.font = new TFont(this);
        this.font.onChange = ()=> {
            this._fontChanged();
        }
        this.font.onColorChange = ()=> {
            this._fontChanged();
        }
        /* 缩放大小？？？ ===对应到点？？？？ */
        this.scaleSize = TPoint.Create(1, 1);
        this.prepareContext(1);

    }

    /**
     * 画笔change后事件
     *
     * @private
     */
    _penChanged() {
        this._states.delete(TCanvasStates.PenValid);
    }

    /**
     * 格式刷改变后事件
     *
     * @private
     */
    _brushChanged() {
        this._states.delete(TCanvasStates.BrushValid);
    }

    /**
     * 字体改变后事件
     *
     * @private
     */
    _fontChanged() {
        this._states.delete(TCanvasStates.FontValid);
    }

    /**
     * 准备上下文
     *
     * @param scale
     */
    prepareContext(scale) {
        this._scale = scale;
        this.h5Context.scale(scale, scale);
        this.h5Context.shadowColor = "black";
        /* 文本基线。em方框的顶端 */
        this.h5Context.textBaseline = "top";
        /* 文本于横坐标的对齐方式，左对齐 */
        this.h5Context.textAlign = "left";
        /* 向线条的每个末端添加正方形线帽 butt|round|square */
        this.h5Context.lineCap = "square";
        /* 线条样式 空数组表示实线 */
        this.h5Context.setLineDash([]);
        this.h5Context.lineDashOffset = 0;
        this.h5Context.font = "10pt 宋体";
        this.font.name = "宋体";
        this.font.size = 10;
        this.font.styles.clear();
        this._states.clear();
    }
}
