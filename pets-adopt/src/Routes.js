import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from './pages/Home'

export default () => {

    return (
        <Switch>
            <Route exact path='/home'>
                <Home/>
            </Route>

            <Route exact path='/adocao'>
                Pagina Adocao
            </Route>
        </Switch>
    );
}