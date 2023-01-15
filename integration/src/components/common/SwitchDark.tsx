/* 切换主题组件 */
import {setThemeConfig} from "@/stores/modules/global/action";
import {connect} from "react-redux";
import {Switch} from "antd";

const SwitchDark = (props: any) => {
    const { setThemeConfig, themeConfig } = props;
    const onChange = (checked: boolean)=> {
        setThemeConfig({...themeConfig, isDark: checked})
    }
    return (
        <Switch
            className="dark"
            defaultChecked={themeConfig.isDark}
            checkedChildren={<>🌞</>}
            unCheckedChildren={<>🌜</>}
            onChange={onChange}
        />
    )
}

const mapStateToProps = (state: any) => state.global;
const mapDispatchToProps = {setThemeConfig}

export default connect(mapStateToProps, mapDispatchToProps)(SwitchDark);