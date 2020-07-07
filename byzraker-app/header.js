import React from 'react';
import {Icon, Overlay, Button} from 'react-native-elements';

import {View, Text, AsyncStorage} from 'react-native';

import StatusBar from './statusbar';
export default function HeaderComponent(props) {
  const [menuOpen, setMenuOpen] = React.useState(false);
  console.log(props.nav);
  console.log(props.isLoggedIn);
  return (
    <>
      <StatusBar backgroundColor="#2EBD6B" barStyle="light-content" />
      <View
        style={{
          backgroundColor: '#2F55C0',
          flexDirection: 'row',
          height: 60,
          alignItems: 'center',
        }}>
        {props.title != 'Home' ? (
          <View style={{justifyContent: 'flex-start', paddingLeft: 10}}>
            <Icon
              onPress={props.handleBackPress}
              color="#fff"
              name="arrow-back"
            />
          </View>
        ) : null}

        <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
          <Text style={{color: '#fff'}}> {props.title}</Text>
        </View>
        <View
          style={{
            paddingRight: 10,
            flexDirection: 'row',
            alignItems: 'center',
            justifyContent: 'center',
          }}>
          <View style={{paddingRight: 10}}>
            <Icon
              onPress={() => props.handleTransition('Search', '/search')}
              color="#fff"
              name="search"
            />
          </View>

          <Icon
            color="#fff"
            name="person"
            onPress={() => setMenuOpen(!menuOpen)}
          />
        </View>
      </View>
      {menuOpen && (
        <Overlay
          height={250}
          isVisible={true}
          onBackdropPress={() => setMenuOpen(false)}>
          <View style={{flex: 1, justifyContent: 'center'}}>
            {props.isLoggedIn && (
              <View style={{marginTop: 10}}>
                <Button
                  onPress={() => {
                    setMenuOpen(false);
                    props.setProfile();
                  }}
                  title="Profile"
                />
              </View>
            )}
            <View style={{marginTop: 10}}>
              <Button
                onPress={async () => {
                  setMenuOpen(false);
                  props.handleTransition(
                    'Push Notfication',
                    '/pushnotification',
                  );
                }}
                type="outline"
                title={'Push Notification'}
              />
            </View>
            <View style={{marginTop: 10}}>
              <Button
                onPress={async () => {
                  setMenuOpen(false);
                  props.handleTransition('Location', '/locationPreference');
                }}
                type="outline"
                title={'Location Preference'}
              />
            </View>

            <View style={{marginTop: 10}}>
              <Button
                onPress={async () => {
                  if (props.isLoggedIn) {
                    await AsyncStorage.clear();
                    props.setLogout();
                  } else {
                    await AsyncStorage.clear();
                    props.setLogin();
                  }

                  setMenuOpen(false);
                }}
                type="outline"
                title={props.isLoggedIn == true ? 'Log Out' : 'Log In'}
              />
            </View>
          </View>
        </Overlay>
      )}
    </>
  );
}
