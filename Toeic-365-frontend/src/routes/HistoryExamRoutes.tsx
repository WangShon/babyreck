import { Switch } from "react-router-dom";
import { Path } from "../constants/path";
import PrivateRoute from "../guards/PrivateRoute";
import HistoryExam from "../pages/user/TestOnline/history/historyExam/2023/HistoryExam";

export default function HistoryExamRoutes() {
    return (
        <Switch>
            <PrivateRoute
                exact={true}
                path={Path.HistoryExam}
                component={() => (<HistoryExam />)}
            />
        </Switch>
    )
}