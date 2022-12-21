import React, {useCallback} from "react";
import {Switch, Select} from "antd";
import Icon from "antd/lib/icon";
import {DispatchProp} from "react-redux";

const MarkdownTheme: React.FC<{configInfo?: IConfigInfoProps} & DispatchProp> = ({ configInfo = {}, dispatch })=> {
    const updateConfigInfo = useCallback(
        (info: any) => {
            dispatch({
                type: 'global/upState',
                data: {
                    configInfo: {
                        ...configInfo,
                        ...info
                    }
                }
            })
        }, [configInfo]
    )

    return (
        <div></div>
    )
}

export default MarkdownTheme;