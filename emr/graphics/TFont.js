/**
 * 字体控制单元
 *
 */
import {TGraphicObj} from "./TGraphicObj";
import {TColor} from "./TColor";
import {TFontStyles} from "./TFontStyles";

/* 字体样式 */
export let TFontStyle = {
    Bold: 1,
    Italic: 2,
    Underline: 4,
    StrikeOut: 8,
    SuperScript: 16,
    SubScript: 32
}

export class TFont extends TGraphicObj {
    /* 2812 */
    constructor(emr) {
        super(emr);
        /* 默认字体 */
        this._name = "宋体";
        /* 默认大小 */
        this._size = 10;
        /* 经过换算的 */
        this._measured = false;
        /* 高度 */
        this._height = 13;
        /* 不晓得干嘛的 ???? */
        this._ascent = 11;
        /* 也不晓得干嘛的 ???? */
        this._otmMacAscent = 0;
        /* 不晓得干嘛的 ？？？？ */
        this._otmMacDescent = 0;
        /* 不晓得干嘛的 ？？？？ */
        this._externalLeading = 2;
        /* 字体默认颜色 */
        this._color = TColor.Black;
        /* 平均字符宽度 */
        this._advCharWidth = 7;
        /* 不晓得干嘛的？？？？ */
        this._CJK = true;
        /* 实际类型 */
        this._trueType = true;
        /* 字体样式 */
        this._styles = new TFontStyles();
        this._styles.onChange = ()=> {
            this.doChange_();
        }
        this.meaChar = false;
        this.onColorChange = null;
        this.emr = emr;
    }

    /**
     * 重置大小
     *
     * @private
     */
    _reSetSize() {

    }

    /**
     * 获取字体名
     *
     */
    get name() {
        return this._name;
    }

    /**
     * 设置字体名
     *
     * @param val
     */
    set name(val) {
        if (this._name !== val) {
            this._name = val;
            this._CJK = (/^[\u3220-\uFA29]+$/.test(val));
            this._reSetSize();
            this.doChange_();
        }
    }

    /**
     * 获取字体大小
     * @returns {number|*}
     */
    get size() {
        return this._size;
    }

    /**
     * 设置字体大小
     * @param val
     */
    set size(val) {
        let sz = val;  // val.replace(/[^\d.]/g, "");  // 容错，去掉单位
        if (this._size !== sz) {
            this._size = sz;
            this._reSetSize();
            this.doChange_();
        }
    }

    get color() {
        return this._color;
    }

    set color(val) {
        if (this._color !== val) {
            this._color = val;
            this.doChange_();
            if (this.onColorChange != null)
                this.onColorChange();
        }
    }

    get styles() {
        return this._styles;
    }

    set styles(val) {
        this._styles = val;
        this._reSetSize();
        this.doChange_();
    }

    get height() {
        return this._height;
    }

    get advCharWidth() {
        return this._advCharWidth;
    }

    get CJK() {
        return this._CJK;
    }

    get trueType() {
        return this._trueType;
    }

    get ascent() {
        return this._ascent;
    }

    get descent() {
        return this._height - this._ascent;
    }

    get externalLeading() {
        return this._externalLeading;
    }
}