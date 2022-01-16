import { combineReducers ,createStore} from 'redux'

/* import MasterReducer from './reducers/MasterReducer'
import FilterReducer from './reducers/FilterReducer'
import UserReducer from './reducers/UserReducer'
 */
import UserReducer from './Reducers/UserReducer'
var store = createStore(combineReducers({
    /* masterdata : MasterReducer,
    filter : FilterReducer, */
    Users :UserReducer
}),{
    /* masterdata : { categories : [] , brands : [] , products : [] } ,
    filter : { categories : [] , brands : []  } , */
    Users : { loginstatus : false , token : undefined,email: undefined}
})

export default store