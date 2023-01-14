/* 类型判断 */
const toString = Object.prototype.toString;
export function is(val: unknown, type: string) {
    return toString.call(val) === `[object ${type}]`;
}

export function isObject(val: any): val is Record<any, any> {
    return val !== null && is(val, 'Object');
}