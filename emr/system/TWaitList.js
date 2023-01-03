/**
 * 等待列表  不晓得干嘛的  先写着
 *
 */
import {TList} from "./TList";
import {TRect} from "./TRect";

export class TWaitList extends TList {
    /* 67654 */
    constructor(ownsObjects = true) {
        super(ownsObjects);
        this.rect = TRect.CreateByBounds(0, 0, 300, 20);
    }
}