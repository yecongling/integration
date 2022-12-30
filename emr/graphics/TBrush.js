/**
 * 不晓得啥 貌似是做格式刷
 *
 */
import {TGraphicObj} from "./TGraphicObj";

export let TBrushStyle = {
    Solid: 0,
    Clear: 1,
    Gradient: 2
}

export class TBrush extends TGraphicObj {
    /* 3429 */
    constructor() {
        super();
        this._color = "White";
        this._style = TBrushStyle.Solid;
        this.onColorChange = null;
    }
}