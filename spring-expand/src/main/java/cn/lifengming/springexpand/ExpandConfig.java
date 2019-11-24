package cn.lifengming.springexpand;

import cn.lifengming.spring.common.Apple;
import cn.lifengming.springexpand.mybean.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 拓展原理：
 * 1、BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor：beanFactory的后置处理器
 *                  在beanFactory标准初始化之后调用，所有bean定义已经保存加载到beanFactory，但是bean的实例还没有创建
 *
 * 1)ioc容器创建
 * 2)invokeBeanFactoryPostProcessors（beanFactory）;执行BeanFactoryPostProcessor
 *      如何找到所有BeanFactoryPostProcessor方法并执行
 *          1）直接在BeanFactory里面找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *          2)在初始化创建其他组件前面执行
 *2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *          postProcessBeanDefinitionRegistry()
 *          在所有bean定义信息将要被加载，但是bean实例还未创建的;
 *
 *          优先于BeanPostProcessor执行
 *          利用BeanDefinitionRegistryPostProcessor给容器在额外添加一些组件；
 *          原理
 *              1)IOC容器创建对象
 *              2）refresh（） ->invokeBeanFactoryPostProcessors(beanFactory)
 *              3)从容器中获取所有的BeanDefinitionRegistryPostProcessor组件
 *                  1、依次触发postProcessBeanDefinitionRegistry()方法；
 *                  2，再触发PostProcessBeanFactory()方法的BeanFactoryPostProcessors
 *             4）再来容器中找到PostProcessBeanFactory组件，再触发PostProcessBeanFactory()
 * 3、ApplicationListener:监听容器中发布的事件。事件驱动模型开发；
 *      public interface ApplicationListener<E extends ApplicationEvent>
 *          监听ApplicationEvent以及以下的事件
 *    步骤：
 *      1）、写一个监听器来监听某个事件（ApplicationEvent及其子类）
 *              @EventListener；
 *              原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener
 *                  SmartInitializingSingleton原理：
 *      2）、把监听器加入到容器
 *      3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 *              ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布ContextRefreshedEvent事件
 *              ContextClosedEvent：容器关闭事件
 *      4）、发布一个事件 ：
 *               applicationContext.publishEvent（）；
 *    原理：
 *         ContextRefreshedEvent \cn.lifengming.spring.expand.Test$1 \org.springframework.context.event.ContextClosedEvent
 *         1、ContextRefreshedEvent事件
 *              1) 容器创建对象：refresh()
 *              2) finishRefresh();容器完成刷新
 *              3） publishEvent(new ContextRefreshedEvent(this))
 *                    事件发布流程：
 *                         1）获取事件的多播器（派发器）：getApplicationEventMulticaster()
 *                         2）multicastEvent派发事件：
 *                         3）获取所有的getApplicationListeners
 *                              for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                              1）如果有Executor，可以支持使用Excutor进行异步派发
 *                                  Executor executor = getTaskExecutor()
 *                              2）否则，同步的方式直接执行listener方法；
 *                                  invokeListener(listener, event)，
 *                                 拿到listener回调lonApplicationEvent方法
 *      【事件多发器（派发器）】
 *          1、容器创建对象：refresh（）
 *          2、initApplicationEventMulticaster();初始化ApplicationEventMulticaster()
 *              1）、先去容器中去找有沒有id=“applicationEventMulticaster”的組件
 *              2）、如果沒有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *                     并且加入到容器中，我们就可以在其他组件派发事件的时候，自动注入这个applicationEventMulticaster；
 *      【容器中有哪些监听器】
 *          1、容器创建对象：refresh（）
 *          2、registerListeners();
 *              从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中
 *      		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *              蒋listener注册到applicationEventMulticaster
 *              getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *  @author lifengming
 * @date 2019-07-22 21:38
 */
@ComponentScan("cn.lifengming.springexpand.*")
@Configuration
public class ExpandConfig {

    @Bean
    public People people(){
        return new People();
    }

}
