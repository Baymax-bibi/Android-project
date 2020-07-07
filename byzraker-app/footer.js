import CNN from './cnn.png';
import FOX from './fox.png';
import ESPN from './espn.png';
import WT from './twitter.png';
import {Icon} from 'react-native-elements';
import React from 'react';

import {
  Text,
  View,
  NativeModules,
  TouchableOpacity,
  Image,
  StyleSheet,
} from 'react-native';

export default function Footer(props) {
  let routename = 'Home';
  return (
    <View style={{borderTopColor: '#ccc', borderTopWidth: 1}}>
      <View
        style={{
          flexDirection: 'row',
          margin: 3,
          height: 50,
        }}>
        <View
          style={
            routename == 'Home'
              ? {
                  ...styles.active,
                  justifyContent: 'center',
                  alignItems: 'center',
                }
              : styles.imageContainer
          }>
          <TouchableOpacity
            style={{flex: 1, backgroundColor: '#fff'}}
            onPress={() => props.handleTransition('Home', '/')}>
            <View
              style={{
                backgroundColor: '#fff',
                paddingLeft: 10,
                paddingRight: 10,
              }}>
              <Icon name="home" style={{color: 'violet'}} />
            </View>
          </TouchableOpacity>
        </View>

        <View
          style={routename == 'Cnn' ? styles.active : styles.imageContainer}>
          <TouchableOpacity
            style={{flex: 1}}
            onPress={() => props.handleTransition('CNN', '/cnnfeed')}>
            <Image source={CNN} style={styles.image} />
          </TouchableOpacity>
        </View>
        <View
          style={routename == 'Espn' ? styles.active : styles.imageContainer}>
          <TouchableOpacity
            style={{flex: 1}}
            onPress={() => props.handleTransition('Espn', '/espnfeed')}>
            <Image source={ESPN} style={styles.image} />
          </TouchableOpacity>
        </View>
        <View
          style={routename == 'Fox' ? styles.active : styles.imageContainer}>
          <TouchableOpacity
            style={{flex: 1}}
            onPress={() => props.handleTransition('Fox', '/foxfeed')}>
            <Image source={FOX} style={styles.image} />
          </TouchableOpacity>
        </View>
        <View
          style={
            routename == 'Worldtweet' ? styles.active : styles.imageContainer
          }>
          <TouchableOpacity
            style={{flex: 1}}
            onPress={() =>
              props.handleTransition('World Tweets', '/worldtweets')
            }>
            <Image source={WT} style={styles.image} />
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    flex: 1,
    margin: 3,
  },
  imageContainer: {
    flex: 1,
    padding: 10,
  },
  image: {
    width: '100%',
    height: '100%',
  },
  active: {
    borderWidth: 1,
    borderColor: '#ccc',
    flex: 1,
    padding: 10,
  },
});
